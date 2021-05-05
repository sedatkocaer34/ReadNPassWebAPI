using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Interfaces
{
    public interface IBookDetailService
    {
        Task<IEnumerable<BookDetailViewModel>> GetAll();
        Task<BookDetailViewModel> GetById(Guid Id);
        Task<CustomResponse<BookDetailViewModel>> AddBookDetail(BookDetailViewModel bookDetailWiewModel);
        Task<CustomResponse<BookDetailViewModel>> UpdateBookDetail(BookDetailViewModel bookDetailWiewModel);
        Task<bool> RemoveBookDetail(Guid Id);
    }
}
