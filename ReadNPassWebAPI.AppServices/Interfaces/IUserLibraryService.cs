using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Interfaces
{
    public interface IUserLibraryService
    {
        Task<IEnumerable<UserLibraryViewModel>> GetAll();

        Task<UserLibraryViewModel> GetById(Guid Id);

        Task<CustomResponse<BookPhotoViewModel>> AddUserLibrary(UserLibraryViewModel userLibraryViewModel);

        Task<CustomResponse<BookPhotoViewModel>> UpdateUserLibrary(UserLibraryViewModel userLibraryViewModel);

        Task<CustomResponse<bool>> RemoveUserLibrary(Guid Id);
    }
}
