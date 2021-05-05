using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class UserLibrary : IEntity
    {
        public Guid Id { get; set; }
        public string LibraryName { get; private set; }
        public Guid UserId { get; private set; }
        public virtual List<Book> Books { get; set; }
        public virtual User User { get; set; }
    }
}
