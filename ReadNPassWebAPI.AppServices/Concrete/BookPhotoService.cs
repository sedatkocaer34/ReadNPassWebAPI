using AutoMapper;
using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using ReadNPassWebAPI.Data.Interfaces;
using ReadNPassWebAPI.Domain.Entity;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class BookPhotoService : IBookPhotoService
    {

        private IBookRepository _bookRepository;
        private IMapper _mapper;

        public BookPhotoService(IBookRepository bookRepository, IMapper mapper)
        {
            this._bookRepository = bookRepository;
            this._mapper = mapper;
        }

        public async Task<CustomResponse<BookPhotoViewModel>> AddBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            int repsonse = _bookRepository.Add(_mapper.Map<Book>(bookViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookPhotoViewModel>(true, "Success");
            }
            return new CustomResponse<BookPhotoViewModel>(true, "Error");
        }

        public async Task<IEnumerable<BookPhotoViewModel>> GetAll()
        {
            return _mapper.Map<List<BookPhotoViewModel>>(_bookRepository.GetList());
        }

        public async Task<BookPhotoViewModel> GetById(Guid Id)
        {
            return _mapper.Map<BookPhotoViewModel>(_bookRepository.GetById(Id));
        }

        public async Task<CustomResponse<bool>> RemoveBookPhoto(Guid Id)
        {
            int repsonse = _bookRepository.Delete(_mapper.Map<Book>(new Book() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookPhotoViewModel>> UpdateBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            int repsonse = _bookRepository.Update(_mapper.Map<Book>(bookViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookPhotoViewModel>(true, "Success");
            }
            return new CustomResponse<BookPhotoViewModel>(true, "Error");
        }
    }
}
