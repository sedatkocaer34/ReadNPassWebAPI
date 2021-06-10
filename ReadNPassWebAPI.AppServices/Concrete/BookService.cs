using AutoMapper;
using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Helpers;
using ReadNPassWebAPI.Core.Response;
using ReadNPassWebAPI.Data.Interfaces;
using ReadNPassWebAPI.Domain.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class BookService : IBookService
    {
        private IBookRepository _bookRepository;
        private IBookPhotoRepository _bookPhotoRepository;
        private IBookDetailRepository _bookDetailRepository;
        private ICloudinaryAPI _cloudinaryAPI;
        private IMapper _mapper;

        public BookService(IBookRepository bookRepository, IBookPhotoRepository bookPhotoRepository, IBookDetailRepository bookDetailRepository, IMapper mapper, ICloudinaryAPI cloudinaryAPI)
        {
            _bookRepository = bookRepository;
            _bookPhotoRepository = bookPhotoRepository;
            _bookDetailRepository = bookDetailRepository;
            _mapper = mapper;
            _cloudinaryAPI = cloudinaryAPI;
        }

        public async Task<CustomResponse<BookPhotoViewModel>> AddBook(BookViewModel bookViewModel)
        {
            bookViewModel.Id = Guid.NewGuid();
            var bookDto = _mapper.Map<Book>(bookViewModel);
            bookDto.UserId = bookViewModel.UserId;
            bookDto.UserLibraryId = Guid.Parse("287ec72b-05ac-4fcf-1c90-08d91304fd81");
            int repsonse = _bookRepository.Add(bookDto);
            if (repsonse>0)
            {
                bookViewModel.BookDetailViewModel.Id = Guid.NewGuid();
                bookViewModel.BookDetailViewModel.BookId = bookViewModel.Id;

                var responseDetail =  _bookDetailRepository.Add(_mapper.Map<BookDetail>(bookViewModel.BookDetailViewModel));

                if (responseDetail>0)
                {
                    List<BookPhoto> bookPhotos = new List<BookPhoto>();
                    for (int i = 0; i < bookViewModel.PhotoList.Count; i++)
                    {
                        BookPhoto bookPhoto = new BookPhoto();
                        bookPhoto.Id = Guid.NewGuid();
                        bookPhoto.BookPhotoUrl= "https://res.cloudinary.com" + await _cloudinaryAPI.uploadImage(bookViewModel.PhotoList[i]);
                        bookPhoto.BookId = bookViewModel.Id;
                        bookPhotos.Add(bookPhoto);
                    }

                    var bookPhotoRes =  _bookPhotoRepository.AddRange(bookPhotos);
                    if (bookPhotoRes>0)
                    {
                        return new CustomResponse<BookPhotoViewModel>(true, "Success");
                    }
                }

               return new CustomResponse<BookPhotoViewModel>(false, "Error");
            }
            return new CustomResponse<BookPhotoViewModel>(false, "Error");
        }

        public async Task<IEnumerable<BookViewModel>> GetAll()
        {
            try
            {
                var userBook = _bookRepository.GetList(x=>x.Id!=Guid.Empty);
                var bookmap = _mapper.Map<List<BookViewModel>>(userBook);
                foreach (var item in bookmap)
                {
                    item.BookDetailViewModel = _mapper.Map<BookDetailViewModel>(_bookDetailRepository.Get(x => x.BookId == item.Id));
                    var data = _bookPhotoRepository.Get(x => x.BookId == item.Id);
                    if (data != null)
                    {
                        item.BookPhoto = data.BookPhotoUrl;
                    }
                }

                return bookmap;
            }
            catch (Exception ex)
            {

                throw;
            }
        }

        public async Task<BookViewModel> GetBookDetail(Guid Id)
        {
            try
            {
                var userBook = _bookRepository.GetById(Id);
                var bookmap = _mapper.Map<BookViewModel>(userBook);

                bookmap.BookDetailViewModel = _mapper.Map<BookDetailViewModel>(_bookDetailRepository.Get(x => x.BookId == bookmap.Id));
                 var data = _bookPhotoRepository.GetList(x => x.BookId == bookmap.Id);
                 if (data != null)
                 {
                    bookmap.BookPhotos = _mapper.Map<List<BookPhotoViewModel>>(data);
                 }

                return bookmap;
            }
            catch (Exception ex)
            {

                throw;
            }
        }

        public async Task<BookViewModel> GetById(Guid Id)
        {
            var book = _bookRepository.GetById(Id);
            var response= _mapper.Map<BookViewModel>(book);
            response.BookDetailViewModel = _mapper.Map < BookDetailViewModel >(_bookDetailRepository.Get(x=>x.BookId== book.Id));
            return response;
        }

        public async Task<List<BookViewModel>> GetUserBook(Guid UserId)
        {
            var userBook =  _bookRepository.GetList(x => x.UserId == UserId).ToList();
            var bookmap = _mapper.Map<List<BookViewModel>>(userBook);
            foreach (var item in bookmap)
            {
                item.BookDetailViewModel= _mapper.Map <BookDetailViewModel>(_bookDetailRepository.Get(x => x.BookId == item.Id));
              var data = _bookPhotoRepository.Get(x => x.BookId == item.Id);
                if (data!=null)
                {
                    item.BookPhoto = data.BookPhotoUrl;
                }
            }

            return bookmap;
        }

        public async Task<CustomResponse<bool>> RemoveBook(Guid Id)
        {
            try
            {
                _bookDetailRepository.Delete(_bookDetailRepository.Get(x => x.BookId == Id));
                foreach (var item in _bookPhotoRepository.GetList(x=>x.BookId==Id))
                {
                    _bookPhotoRepository.Delete(item);
                }
                var book = _bookRepository.GetById(Id);
                int repsonse = _bookRepository.Delete(book);
                if (repsonse > 0)
                {
                    return new CustomResponse<bool>(true, "Success");
                }
                return new CustomResponse<bool>(false, "Error");
            }
            catch (Exception ex)
            {

                throw;
            }
        }

        public async Task<CustomResponse<BookPhotoViewModel>> UpdateBook(BookViewModel bookViewModel)
        {
            try
            {
                int bookupdate = _bookRepository.Update(_mapper.Map<Book>(bookViewModel));
                if (bookupdate > 0)
                {
                    var bookDetailModel = _bookDetailRepository.Get(x=>x.BookId== bookViewModel.Id);
                    bookViewModel.BookDetailViewModel.Id = bookDetailModel.Id;
                    int repsonse = _bookDetailRepository.Update(_mapper.Map<BookDetail>(bookViewModel.BookDetailViewModel));
                    if (repsonse > 0)
                    {
                        return new CustomResponse<BookPhotoViewModel>(true, "Success");
                    }
                    else
                    {
                        return new CustomResponse<BookPhotoViewModel>(false, "Error");
                    }

                }
                return new CustomResponse<BookPhotoViewModel>(false, "Error");
            }
            catch (Exception ex)
            {

                throw;
            }
        }
    }
}
