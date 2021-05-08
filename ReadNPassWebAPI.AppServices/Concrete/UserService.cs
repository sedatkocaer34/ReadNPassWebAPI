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
    public class UserService : IUserService
    {

        private IUserRepository _userRepository;
        private IMapper _mapper;

        public UserService(IUserRepository userRepository, IMapper mapper)
        {
            this._userRepository = userRepository;
            this._mapper = mapper;
        }

        public async Task<CustomResponse<BookPhotoViewModel>> AddUser(UserViewModel userViewModel)
        {
            int repsonse = _userRepository.Add(_mapper.Map<User>(userViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookPhotoViewModel>(true, "Success");
            }
            return new CustomResponse<BookPhotoViewModel>(true, "Error");
        }

        public async Task<IEnumerable<UserViewModel>> GetAll()
        {
            return _mapper.Map<List<UserViewModel>>(_userRepository.GetList());
        }

        public async Task<UserViewModel> GetById(Guid Id)
        {
            return _mapper.Map<UserViewModel>(_userRepository.GetById(Id));
        }

        public async Task<CustomResponse<bool>> RemoveUser(Guid Id)
        {
            int repsonse = _userRepository.Delete(_mapper.Map<User>(new User() { Id = Id }));
            if (repsonse > 0)
            {
                return new CustomResponse<bool>(true, "Success");
            }
            return new CustomResponse<bool>(true, "Error");
        }

        public async Task<CustomResponse<BookPhotoViewModel>> UpdateUser(UserViewModel userViewModel)
        {
            int repsonse = _userRepository.Update(_mapper.Map<User>(userViewModel));
            if (repsonse > 0)
            {
                return new CustomResponse<BookPhotoViewModel>(true, "Success");
            }
            return new CustomResponse<BookPhotoViewModel>(true, "Error");
        }
    }
}
