using ReadNPassWebAPI.Core.Entity;
using System;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class BookPhoto : IEntity
    {
        public Guid Id { get; set; }
        public Guid BookId { get; private set; }
        public string BookPhotoUrl { get; private set; }
        public virtual Book Book { get; set; }
    }
}
