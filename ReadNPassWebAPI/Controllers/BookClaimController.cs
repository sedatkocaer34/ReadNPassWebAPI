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
    public class BookClaimController : Controller
    {
        private IBookClaimService _bookClaimService;

        public BookClaimController(IBookClaimService bookClaimService)
        {
            _bookClaimService = bookClaimService;
        }

        [HttpGet]
        public IActionResult GetBookClaim(Guid Id)
        {
            var response = _bookClaimService.GetById(Id);
            return Ok(response);
        }

        [HttpPost]
        public async Task<IActionResult> AddBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            var response = await _bookClaimService.AddBookClaim(bookClaimViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }

        [HttpPut]
        public async Task<IActionResult> UpdateBookClaim(BookClaimViewModel bookClaimViewModel)
        {
            var response = await _bookClaimService.UpdateBookClaim(bookClaimViewModel);
            if (response.Success)
            {
                return Ok(response);
            }
            return BadRequest(response);
        }

        [HttpGet]
        public async Task<IActionResult> GetAllBookClaim()
        {
            var response = await _bookClaimService.GetAll();
            return Ok(response);
        }

        [HttpDelete]
        public async Task<IActionResult> DeleteBookClaim(Guid Id)
        {
            var response = await _bookClaimService.RemoveBookClaim(Id);
            return Ok(response);
        }
    }
}
