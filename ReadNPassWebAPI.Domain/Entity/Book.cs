using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class Book: IEntity
    {
        public Guid Id { get; set; }
        public string BookName { get;private set; }
        public bool Sell { get; set; }
        public DateTime BookCreateDate { get; set; }
        public DateTime BookUpdateDate { get; set; }
        public Guid UserLibraryId { get;  set; }
        public Guid UserId { get; set; }
        public bool Sales { get; set; }
        public bool Swap { get; set; }

      virtual  public  BookDetail BookDetail { get; set; }
      virtual  public  List<BookClaim> BookClaims { get; set; }
      virtual  public  List<BookPhoto> BookPhotos { get; set; }
      virtual  public  UserLibrary UserLibrary { get; set; }
        virtual public  User User { get; set; }
    }
}
