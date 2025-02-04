﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ReadNPassWebAPI.Core.Security
{
    public interface IPasswordHash
    {
        string Hash(string hashText);
        bool VerifHash(string text, string hashText);
    }
}
