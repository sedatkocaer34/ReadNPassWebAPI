using ReadNPassWebAPI.Core.Entity;
using System;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class BookDetail : IEntity
    {
        public Guid Id { get; set; }
        public Guid BookId { get; private set; }
        public string BookDescription { get; private set; }
        public string WriterName { get; private set; }
        public string BookKind { get; private set; }
        public double BookPrice { get; private set; }
        public virtual Book Book { get; set; }
    }
}
