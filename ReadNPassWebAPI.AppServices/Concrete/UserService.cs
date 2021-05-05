using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class UserService : IUserService
    {
        public Task<CustomResponse<BookPhotoViewModel>> AddUser(UserViewModel userViewModel)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<UserViewModel>> GetAll()
        {
            throw new NotImplementedException();
        }

        public Task<UserViewModel> GetById(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<bool>> RemoveUser(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<BookPhotoViewModel>> UpdateUser(UserViewModel userViewModel)
        {
            throw new NotImplementedException();
        }
    }
}
