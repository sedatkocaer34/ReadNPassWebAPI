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
        private IBookDetailRepository _bookDetailRepository;
        private IMapper _mapper;

        public BookDetailService(IBookDetailRepository bookDetailRepository, IMapper mapper)
        {
            _bookDetailRepository = bookDetailRepository;
            _mapper = mapper;
        }

        public async Task<CustomResponse<BookDetailViewModel>> AddBookDetail(BookDetailViewModel bookDetailWiewModel)
        {
            int repsonse = _bookDetailRepository.Add(_mapper.Map<BookDetail>(bookDetailWiewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookDetailViewModel>(true, "Success");
            }
            return new CustomResponse<BookDetailViewModel>(true, "Error");
        }

        public async Task<IEnumerable<BookDetailViewModel>> GetAll()
        {
            return _mapper.Map<List<BookDetailViewModel>>(_bookDetailRepository.GetList());
        }

        public async Task<BookDetailViewModel> GetById(Guid Id)
        {
            return _mapper.Map<BookDetailViewModel>(_bookDetailRepository.GetById(Id));
        }

        public async Task<CustomResponse<bool>> RemoveBookDetail(Guid Id)
        {
            int repsonse = _bookDetailRepository.Delete(_mapper.Map<BookDetail>(new BookDetail() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookDetailViewModel>> UpdateBookDetail(BookDetailViewModel bookDetailWiewModel)
        {
            int repsonse = _bookDetailRepository.Update(_mapper.Map<BookDetail>(bookDetailWiewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookDetailViewModel>(true, "Success");
            }
            return new CustomResponse<BookDetailViewModel>(true, "Error");
        }
    }
}
