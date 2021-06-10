using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
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
        public async Task<IActionResult> GetBook(Guid Id)
        {
            var response = await _bookService.GetById(Id);
            return Ok(response);
        }

        [Route("GetUserBook")]
        [HttpGet]
        public async Task<IActionResult> GetUserBook(Guid Id)
        {
            var response = await _bookService.GetUserBook(Id);
            return Ok(response);
        }
        [Route("AddBook")]
        [HttpPost]
        public async Task<IActionResult> AddBook()
        {
            try
            {
                var request = HttpContext.Request;
                var ds = request.Form.Files;
                var dse = request.Form["bookViewModel"].ToString();
                var data = JsonConvert.DeserializeObject<BookViewModel>(dse);
                data.PhotoList = new System.Collections.Generic.List<Microsoft.AspNetCore.Http.IFormFile>();
                for (int i = 0; i < ds.Count; i++)
                {
                    data.PhotoList.Add(ds[i]);
                }
                
                var response = await _bookService.AddBook(data);
                
               
                    if (response.Success)
                    {
                        return Ok(response);
                    }
                    return BadRequest(response);

            }
            catch (Exception ex)
            {
                return BadRequest("Something went wrong.");
                throw;
            }
            return Ok();
        }
		[Route("UpdateBook")]
        [HttpPut]
        public async Task<IActionResult> UpdateBook([FromBody] BookViewModel bookViewModel)
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

        [Route("GetBookDetail")]
        [HttpGet]
        public async Task<IActionResult> GetBookDetail(Guid Id)
        {
            var response = await _bookService.GetBookDetail(Id);
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
