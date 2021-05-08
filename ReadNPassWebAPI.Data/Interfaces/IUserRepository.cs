using ReadNPassWebAPI.Core.Data;
using ReadNPassWebAPI.Domain.Entity;
using System;
using System.Collections.Generic;
using System.Text;

namespace ReadNPassWebAPI.Data.Interfaces
{
    public interface IUserRepository : IRepository<User>
    {
    }
}
