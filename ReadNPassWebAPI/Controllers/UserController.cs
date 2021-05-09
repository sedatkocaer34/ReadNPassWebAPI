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
    [Route("api/[controller]")]
    public class UserController : Controller
    {
        private IUserService _userService;

        public UserController(IUserService userService)
        {
            _userService = userService;
        }

        [HttpGet]
        public IActionResult GetUser(Guid Id)
        {
            var response = _userService.GetById(Id);
            return Ok(response);
        }

        [Route("AddUser")]
        [HttpPost]
        public async Task<IActionResult> AddUser(UserViewModel userViewModel)
        {
            var response = await _userService.AddUser(userViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }

        [HttpPut]
        public async Task<IActionResult> UpdatUser(UserViewModel userViewModel)
        {
            var response = await _userService.UpdateUser(userViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }

        [HttpGet]
        public async Task<IActionResult> GetAllUser()
        {
            var response = await _userService.GetAll();
            return Ok(response);
        }

        [HttpDelete]
        public async Task<IActionResult> DeleteUser(Guid Id)
        {
            var response = await _userService.RemoveUser(Id);
            return Ok(response);
        }
    }
}
