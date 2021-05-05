using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class UserLibraryService : IUserLibraryService
    {
        public Task<CustomResponse<BookPhotoViewModel>> AddUserLibrary(UserLibraryViewModel userLibraryViewModel)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<UserLibraryViewModel>> GetAll()
        {
            throw new NotImplementedException();
        }

        public Task<UserLibraryViewModel> GetById(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<bool>> RemoveUserLibrary(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<BookPhotoViewModel>> UpdateUserLibrary(UserLibraryViewModel userLibraryViewModel)
        {
            throw new NotImplementedException();
        }
    }
}
