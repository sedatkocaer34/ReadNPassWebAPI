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
    public class BookPhotoController : Controller
    {
        private IBookPhotoService _bookPhotoService;

        public BookPhotoController(IBookPhotoService bookPhotoService)
        {
            _bookPhotoService = bookPhotoService;
        }
		[Route("GetBookPhoto")]
        [HttpGet]
        public IActionResult GetBookPhoto(Guid Id)
        {
            var response = _bookPhotoService.GetById(Id);
            return Ok(response);
        }
		[Route("AddBookPhoto")]
        [HttpPost]
        public async Task<IActionResult> AddBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            var response = await _bookPhotoService.AddBookPhoto(bookPhotoViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }
		[Route("UpdateBookPhoto")]
        [HttpPut]
        public async Task<IActionResult> UpdateBookPhoto(BookPhotoViewModel bookPhotoViewModel)
        {
            var response = await _bookPhotoService.UpdateBookPhoto(bookPhotoViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }
		[Route("GetAllBookPhoto")]
        [HttpGet]
        public async Task<IActionResult> GetAllBookPhoto()
        {
            var response = await _bookPhotoService.GetAll();
            return Ok(response);
        }
		[Route("DeleteBookPhoto")]
        [HttpDelete]
        public async Task<IActionResult> DeleteBookPhoto(Guid Id)
        {
            var response = await _bookPhotoService.RemoveBookPhoto(Id);
            return Ok(response);
        }
    }
}
