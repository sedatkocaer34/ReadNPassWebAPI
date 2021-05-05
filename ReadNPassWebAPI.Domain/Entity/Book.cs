using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class Book: IEntity
    {
        public Guid Id { get; set; }
        public string BookName { get;private set; }
        public DateTime BookCreateDate { get;private set; }
        public DateTime BookUpdateDate { get;private set; }
        public Guid UserLibraryId { get; private set; }

        public virtual List<BookDetail> BookDetail { get; set; }
        public virtual List<BookClaim> BookClaims { get; set; }
        public virtual List<BookPhoto> BookPhotos { get; set; }
        public virtual UserLibrary UserLibrary { get; set; }
    }
}
