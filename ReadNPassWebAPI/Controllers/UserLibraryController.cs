using Microsoft.AspNetCore.Mvc;
using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UserLibraryController : Controller
    {
        private IUserLibraryService _userLibraryService;

        public UserLibraryController(IUserLibraryService userLibraryService)
        {
            _userLibraryService = userLibraryService;
        }

        [HttpGet]
        public IActionResult GetUserLibrary(Guid Id)
        {
            var response = _userLibraryService.GetById(Id);
            return Ok(response);
        }

        [HttpPost]
        public async Task<IActionResult> AddUserLibrary(UserLibraryViewModel userLibraryViewModel)
        {
            var response = await _userLibraryService.AddUserLibrary(userLibraryViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }

        [HttpPut]
        public async Task<IActionResult> UpdatUserLibrary(UserLibraryViewModel userLibraryViewModel)
        {
            var response = await _userLibraryService.UpdateUserLibrary(userLibraryViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }

        [HttpGet]
        public async Task<IActionResult> GetAllUserLibrary()
        {
            var response = await _userLibraryService.GetAll();
            return Ok(response);
        }

        [HttpDelete]
        public async Task<IActionResult> DeleteUserLibrary(Guid Id)
        {
            var response = await _userLibraryService.RemoveUserLibrary(Id);
            return Ok(response);
        }
    }
}
