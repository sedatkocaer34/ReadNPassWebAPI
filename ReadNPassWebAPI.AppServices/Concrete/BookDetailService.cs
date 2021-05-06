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
    public class BookDetailService : IBookDetailService
    {
        private IBookRepository _bookRepository;
        private IMapper _mapper;

        public async Task<CustomResponse<BookDetailViewModel>> AddBookDetail(BookDetailViewModel bookDetailWiewModel)
        {
            int repsonse = _bookRepository.Add(_mapper.Map<Book>(bookViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookDetailViewModel>(true, "Success");
            }
            return new CustomResponse<BookDetailViewModel>(true, "Error");
        }

        public async Task<IEnumerable<BookDetailViewModel>> GetAll()
        {
            return _mapper.Map<List<BookDetailViewModel>>(_bookRepository.GetList());
        }

        public async Task<BookDetailViewModel> GetById(Guid Id)
        {
            return _mapper.Map<BookDetailViewModel>(_bookRepository.GetById(Id));
        }

        public async Task<bool> RemoveBookDetail(Guid Id)
        {
            int repsonse = _bookRepository.Delete(_mapper.Map<Book>(new Book() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookDetailViewModel>> UpdateBookDetail(BookDetailViewModel bookDetailWiewModel)
        {
            int repsonse = _bookRepository.Update(_mapper.Map<Book>(bookViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookDetailViewModel>(true, "Success");
            }
            return new CustomResponse<BookDetailViewModel>(true, "Error");
        }
    }
}
