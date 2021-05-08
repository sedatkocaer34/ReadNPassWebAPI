using AutoMapper;
using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using ReadNPassWebAPI.Core.Response;
using ReadNPassWebAPI.Data.Interfaces;
using ReadNPassWebAPI.Domain.Entity;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.AppServices.Concrete
{
    public class BookPhotoService : IBookPhotoService
    {

        private IBookPhotoRepository _bookPhotoRepository;
        private IMapper _mapper;

        public BookPhotoService(IBookPhotoRepository bookPhotoRepository, IMapper mapper)
        {
            this._bookPhotoRepository = bookPhotoRepository;
            this._mapper = mapper;
        }

        public async Task<CustomResponse<BookPhotoViewModel>> AddBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            int repsonse = _bookPhotoRepository.Add(_mapper.Map<BookPhoto>(bookPhotoViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookPhotoViewModel>(true, "Success");
            }
            return new CustomResponse<BookPhotoViewModel>(true, "Error");
        }

        public async Task<IEnumerable<BookPhotoViewModel>> GetAll()
        {
            return _mapper.Map<List<BookPhotoViewModel>>(_bookPhotoRepository.GetList());
        }

        public async Task<BookPhotoViewModel> GetById(Guid Id)
        {
            return _mapper.Map<BookPhotoViewModel>(_bookPhotoRepository.GetById(Id));
        }

        public async Task<CustomResponse<bool>> RemoveBookPhoto(Guid Id)
        {
            int repsonse = _bookPhotoRepository.Delete(_mapper.Map<BookPhoto>(new BookPhoto() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookPhotoViewModel>> UpdateBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            int repsonse = _bookPhotoRepository.Update(_mapper.Map<BookPhoto>(bookPhotoViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookPhotoViewModel>(true, "Success");
            }
            return new CustomResponse<BookPhotoViewModel>(true, "Error");
        }
    }
}
