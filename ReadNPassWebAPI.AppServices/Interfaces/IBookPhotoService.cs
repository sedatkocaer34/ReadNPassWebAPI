using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Interfaces
{
    public interface IBookPhotoService
    {
        Task<IEnumerable<BookPhotoViewModel>> GetAll();

        Task<BookPhotoViewModel> GetById(Guid Id);

        Task<CustomResponse<BookPhotoViewModel>> AddBookPhoto(BookPhotoViewModel bookPhotoViewModel);

        Task<CustomResponse<BookPhotoViewModel>> UpdateBookPhoto(BookPhotoViewModel bookPhotoViewModel);

        Task<CustomResponse<bool>> RemoveBookPhoto(Guid Id);
    }
}
