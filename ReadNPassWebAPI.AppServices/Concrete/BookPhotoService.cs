using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class BookPhotoService : IBookPhotoService
    {
        public Task<CustomResponse<BookPhotoViewModel>> AddBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<BookPhotoViewModel>> GetAll()
        {
            throw new NotImplementedException();
        }

        public Task<BookPhotoViewModel> GetById(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<bool>> RemoveBookPhoto(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<BookPhotoViewModel>> UpdateBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            throw new NotImplementedException();
        }
    }
}
