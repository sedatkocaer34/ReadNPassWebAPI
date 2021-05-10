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
		[Route("GetUserLibrary")]
        [HttpGet]
        public IActionResult GetUserLibrary(Guid Id)
        {
            var response = _userLibraryService.GetById(Id);
            return Ok(response);
        }
		[Route("AddUserLibrary")]
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
		[Route("UpdatUserLibrary")]
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
		[Route("GetAllUserLibrary")]
        [HttpGet]
        public async Task<IActionResult> GetAllUserLibrary()
        {
            var response = await _userLibraryService.GetAll();
            return Ok(response);
        }
		[Route("DeleteUserLibrary")]
        [HttpDelete]
        public async Task<IActionResult> DeleteUserLibrary(Guid Id)
        {
            var response = await _userLibraryService.RemoveUserLibrary(Id);
            return Ok(response);
        }
    }
}
