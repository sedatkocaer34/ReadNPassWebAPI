using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class BookDetailService : IBookDetailService
    {
        public Task<CustomResponse<BookDetailViewModel>> AddBookDetail(BookDetailViewModel bookDetailWiewModel)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<BookDetailViewModel>> GetAll()
        {
            throw new NotImplementedException();
        }

        public Task<BookDetailViewModel> GetById(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<bool> RemoveBookDetail(Guid Id)
        {
            throw new NotImplementedException();
        }

        public Task<CustomResponse<BookDetailViewModel>> UpdateBookDetail(BookDetailViewModel bookDetailWiewModel)
        {
            throw new NotImplementedException();
        }
    }
}
