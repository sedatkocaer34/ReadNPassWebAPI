using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Interfaces
{
    public interface IBookClaimService
    {
        Task<IEnumerable<BookClaimViewModel>> GetAll();
        Task<BookClaimViewModel> GetById(Guid Id);
        Task<CustomResponse<BookClaimViewModel>> AddBookClaim(BookClaimViewModel bookClaimViewModel);
        Task<CustomResponse<BookClaimViewModel>> UpdateBookClaim(BookClaimViewModel bookClaimViewModel);
        Task<CustomResponse<bool>> RemoveBookClaim(Guid Id);
    }
}
