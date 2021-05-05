using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class BookClaimService : IBookClaimService
    {
       
        

        public Task<CustomResponse<BookClaimViewModel>> AddBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<BookClaimViewModel>> GetAll()
        {
            throw new NotImplementedException();
        }

        public Task<BookClaimViewModel> GetById(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<bool>> RemoveBookClaim(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<BookClaimViewModel>> UpdateBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            throw new NotImplementedException();
        }
    }
}
