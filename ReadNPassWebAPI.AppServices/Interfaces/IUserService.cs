using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Interfaces
{
    public interface IUserService
    {
        Task<IEnumerable<UserViewModel>> GetAll();

        Task<UserViewModel> GetById(Guid Id);

        Task<CustomResponse<BookPhotoViewModel>> AddUser(UserViewModel userViewModel);

        Task<CustomResponse<BookPhotoViewModel>> UpdateUser(UserViewModel userViewModel);

        Task<CustomResponse<bool>> RemoveUser(Guid Id);
    }
}
