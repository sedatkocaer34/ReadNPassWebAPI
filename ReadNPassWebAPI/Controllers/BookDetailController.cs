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
    public class BookDetailController : Controller
    {
        private IBookDetailService _bookDetailService;

        public BookDetailController(IBookDetailService bookDetailService)
        {
            _bookDetailService = bookDetailService;
        }
       [Route("GetBookDetail")]
        [HttpGet]
        public IActionResult GetBookDetail(Guid Id)
        {
            var response = _bookDetailService.GetById(Id);
            return Ok(response);
        }
		[Route("AddBookDetail")]
        [HttpPost]
        public async Task<IActionResult> AddBookDetail(BookDetailViewModel bookDetailViewModel)
        {
            var response = await _bookDetailService.AddBookDetail(bookDetailViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }
		[Route("UpdateBookDetail")]
        [HttpPut]
        public async Task<IActionResult> UpdateBookDetail(BookDetailViewModel bookDetailViewModel)
        {
            var response = await _bookDetailService.UpdateBookDetail(bookDetailViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }
		[Route("GetAllBookDetail")]
        [HttpGet]
        public async Task<IActionResult> GetAllBookDetail()
        {
            var response = await _bookDetailService.GetAll();
            return Ok(response);
        }
		[Route("DeleteBookDetail")]
        [HttpDelete]
        public async Task<IActionResult> DeleteBookDetail(Guid Id)
        {
            var response = await _bookDetailService.RemoveBookDetail(Id);
            return Ok(response);
        }
    }
}
