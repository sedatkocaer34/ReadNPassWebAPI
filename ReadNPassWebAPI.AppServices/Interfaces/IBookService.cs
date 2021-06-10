using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Interfaces
{
    public interface IBookService
    {
        Task<IEnumerable<BookViewModel>> GetAll();

        Task<BookViewModel> GetBookDetail(Guid Id);

        Task<BookViewModel> GetById(Guid Id);

        Task<List<BookViewModel>> GetUserBook(Guid UserId);

        Task<CustomResponse<BookPhotoViewModel>> AddBook(BookViewModel bookViewModel);

        Task<CustomResponse<BookPhotoViewModel>> UpdateBook(BookViewModel bookViewModel);

        Task<CustomResponse<bool>> RemoveBook(Guid Id);
    }
}
