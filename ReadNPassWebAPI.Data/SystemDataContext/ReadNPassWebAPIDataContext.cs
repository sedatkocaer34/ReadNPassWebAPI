using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace ReadNPassWebAPI.Data.SystemDataContext
{
    public class ReadNPassWebAPIDataContext:DbContext
    {
        public int MyProperty { get; set; }
    }
}
