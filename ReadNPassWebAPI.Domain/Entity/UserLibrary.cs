using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class UserLibrary : IEntity
    {
        public Guid Id { get; set; }
        public string LibraryName { get;  set; }
        public Guid UserId { get;  set; }
       virtual public  List<Book> Books { get; set; }
        virtual public  User User { get; set; }
    }
}
