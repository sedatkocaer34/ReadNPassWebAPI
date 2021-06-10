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

        private IBookClaimRepository _bookClaimRepository;
        private IBookRepository _bookRepository;
        private IUserRepository _userRepository;
        private IMapper _mapper;

        public BookClaimService(IBookClaimRepository bookClaimRepository, IMapper mapper, IBookRepository bookRepository,
            IUserRepository userRepository)
        {
            this._bookClaimRepository = bookClaimRepository;
            this._bookRepository = bookRepository;
            this._userRepository = userRepository;
            this._mapper = mapper;
        }

        public async Task<CustomResponse<BookClaimViewModel>> AddBookClaim(BookClaimViewModel bookClaimViewModel)
        {
           var bookclaim =  _mapper.Map<BookClaim>(bookClaimViewModel);
            bookclaim.Id = Guid.NewGuid();
            int repsonse = _bookClaimRepository.Add(bookclaim);
            if (repsonse > 0)
            {
                return new CustomResponse<BookClaimViewModel>(true, "Success");
            }
            return new CustomResponse<BookClaimViewModel>(true, "Error");
        }

        public async Task<IEnumerable<BookClaimViewModel>> GetAll()
        {
            return _mapper.Map<List<BookClaimViewModel>>(_bookClaimRepository.GetList());
        }

        public async Task<BookClaimViewModel> GetById(Guid Id)
        {
            return _mapper.Map<BookClaimViewModel>(_bookClaimRepository.GetById(Id));
        }

        public async Task<List<BookClaimViewModel>> GetInComeMessageClaim(Guid Id)
        {
            var bookclaim = _mapper.Map<List<BookClaimViewModel>>(_bookClaimRepository.GetList(x => x.UserId == Id));

            foreach (var item in bookclaim)
            {
                item.bookViewModel = _mapper.Map<BookViewModel>(_bookRepository.Get(x => x.Id == item.BookId));
                item.userViewModel = _mapper.Map<UserViewModel>(_userRepository.Get(x => x.Id == item.senderUserId));

            }

            return bookclaim;
        }

        public async Task<List<BookClaimViewModel>> GetUserSendClaim(Guid Id)
        {
           var bookclaim = _mapper.Map < List<BookClaimViewModel >> (_bookClaimRepository.GetList(x => x.senderUserId == Id));

            foreach (var item in bookclaim)
            {
                item.bookViewModel = _mapper.Map<BookViewModel>(_bookRepository.Get(x => x.Id == item.BookId));
                item.userViewModel = _mapper.Map<UserViewModel>(_userRepository.Get(x => x.Id == item.UserId));
                
            }

            return bookclaim;
          
        }

        public async Task<CustomResponse<bool>> RemoveBookClaim(Guid Id)
        {
            int repsonse = _bookClaimRepository.Delete(_mapper.Map<BookClaim>(new BookClaim() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookClaimViewModel>> UpdateBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            int repsonse = _bookClaimRepository.Update(_mapper.Map<BookClaim>(bookClaimViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookClaimViewModel>(true, "Success");
            }
            return new CustomResponse<BookClaimViewModel>(true, "Error");
        }
    }
}
