using ReadNPassWebAPI.Core.Data;
using ReadNPassWebAPI.Data.Interfaces;
using ReadNPassWebAPI.Data.SystemDataContext;
using ReadNPassWebAPI.Domain.Entity;
using System;
using System.Collections.Generic;
using System.Text;

namespace ReadNPassWebAPI.Data.Concrete
{
    public class BookRepository : RepositoryBase<Book, ReadNPassWebAPIDataContext>, IBookRepository
    {
    }
}
