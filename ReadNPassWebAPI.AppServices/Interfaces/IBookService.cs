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

        Task<BookViewModel> GetById(Guid Id);

        Task<CustomResponse<BookPhotoViewModel>> AddBook(BookViewModel bookViewModel);

        Task<CustomResponse<BookPhotoViewModel>> UpdateBook(BookViewModel bookViewModel);

        Task<CustomResponse<bool>> RemoveBook(Guid Id);
    }
}
