using Microsoft.AspNetCore.Mvc;
using ReadNPassWebAPI.AppServices.Interfaces;
using ReadNPassWebAPI.AppServices.ViewModels;
using System;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class BookController :  ControllerBase
    {

        private IBookService _bookService;

        public BookController(IBookService bookService)
        {
            _bookService = bookService;
        }
		[Route("GetBook")]
        [HttpGet]
        public IActionResult GetBook(Guid Id)
        {
            var response = _bookService.GetById(Id);
            return Ok(response);
        }
		[Route("AddBook")]
        [HttpPost]
        public async Task<IActionResult> AddBook(BookViewModel bookViewModel)
        {
            var response = await _bookService.AddBook(bookViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }
		[Route("UpdateBook")]
        [HttpPut]
        public async Task<IActionResult> UpdateBook(BookViewModel bookViewModel)
        {
            var response = await _bookService.UpdateBook(bookViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }
		[Route("GetAllBook")]
        [HttpGet]
        public async Task<IActionResult> GetAllBook()
        {
            var response = await _bookService.GetAll();
            return Ok(response);
        }
		[Route("DeleteBook")]
        [HttpDelete]
        public async Task<IActionResult> DeleteBook(Guid Id)
        {
            var response = await _bookService.RemoveBook(Id);
            return Ok(response);
        }
    }
}
