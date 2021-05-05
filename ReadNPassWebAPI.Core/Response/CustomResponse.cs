using System;
using System.Collections.Generic;
using System.Text;

namespace ReadNPassWebAPI.Core.Response
{
    public class CustomResponse<T>
    {
        public CustomResponse(T data, bool success, string message)
        {
            Data = data;
            Success = success;
            Message = message;
        }

        public CustomResponse(bool success, string message)
        {
            Success = success;
            Message = message;
        }

        public T Data { get; set; }

        public bool Success { get; set; }

        public string Message { get; set; }
    }
}
