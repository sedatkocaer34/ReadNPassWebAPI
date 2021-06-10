using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class User : IEntity
    {
        public Guid Id { get; set; }
        public string Name { get;  set; }
        public string SurName { get;  set; }
        public string Email { get;  set; }
        public string Password { get; set; }
        public double LocationLatidute  { get; private set; }
        public double LongitudeLatidute { get; private set; }
        public string DefaultUserProfiePhoto { get; set; }

      virtual  public  List<UserLibrary> UserLibraries { get; set; }
      virtual  public  List<BookClaim> BookClaims { get; set; }
        virtual public  List<Book> Books { get; set; }
    }
}
