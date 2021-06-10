using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.Core.Helpers
{
    public interface ICloudinaryAPI
    {
        Task <string> uploadImage(IFormFile image);
    }
}
