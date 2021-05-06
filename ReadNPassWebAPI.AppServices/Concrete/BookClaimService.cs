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
    public class BookClaimService : IBookClaimService
    {

        private IBookRepository _bookRepository;
        private IMapper _mapper;

        public BookClaimService(IBookRepository bookRepository, IMapper mapper)
        {
            this._bookRepository = bookRepository;
            this._mapper = mapper;
        }

        public async Task<CustomResponse<BookClaimViewModel>> AddBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            int repsonse = _bookRepository.Add(_mapper.Map<Book>(bookClaimViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookClaimViewModel>(true, "Success");
            }
            return new CustomResponse<BookClaimViewModel>(true, "Error");
        }

        public async Task<IEnumerable<BookClaimViewModel>> GetAll()
        {
            return _mapper.Map<List<BookClaimViewModel>>(_bookRepository.GetList());
        }

        public async Task<BookClaimViewModel> GetById(Guid Id)
        {
            return _mapper.Map<BookClaimViewModel>(_bookRepository.GetById(Id));
        }

        public async Task<CustomResponse<bool>> RemoveBookClaim(Guid Id)
        {
            int repsonse = _bookRepository.Delete(_mapper.Map<Book>(new Book() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookClaimViewModel>> UpdateBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            int repsonse = _bookRepository.Update(_mapper.Map<Book>(bookClaimViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookClaimViewModel>(true, "Success");
            }
            return new CustomResponse<BookClaimViewModel>(true, "Error");
        }
    }
}
