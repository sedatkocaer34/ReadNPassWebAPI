using ReadNPassWebAPI.Core.Entity;
using System;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class BookClaim : IEntity
    {
        public Guid Id { get; set; }
        public Guid BookId { get; set; }

        public Guid UserId { get; set; }

        public Guid senderUserId { get; set; }

        public string Explain { get; set; }

        public bool IsSales { get; set; }

        virtual public  Book Book { get; set; }

        virtual public  User User { get; set; }
    }
}
