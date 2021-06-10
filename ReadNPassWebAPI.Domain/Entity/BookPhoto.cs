using ReadNPassWebAPI.Core.Entity;
using System;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class BookPhoto : IEntity
    {
        public Guid Id { get; set; }
        public Guid BookId { get;  set; }
        public string BookPhotoUrl { get;  set; }
        virtual public  Book Book { get; set; }
    }
}
