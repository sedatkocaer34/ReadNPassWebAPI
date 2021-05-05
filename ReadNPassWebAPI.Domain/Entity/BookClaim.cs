using ReadNPassWebAPI.Core.Entity;
using System;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class BookClaim : IEntity
    {
        public Guid Id { get; set; }
        public Guid BookId { get; set; }

        public Guid UserId { get; set; }

        public virtual Book Book { get; set; }

        public virtual User User { get; set; }
    }
}
