using ReadNPassWebAPI.Core.Entity;
using System;

namespace ReadNPassWebAPI.Domain.Entity
{
    public class User : IEntity
    {
        public Guid Id { get; set; }
        public string Name { get; private set; }
        public string SurName { get; private set; }
        public string Email { get; private set; }
        public byte[] PasswordHash { get; private set; }
        public byte[] PasswordSalt { get; private set; }
        public double LocationLatidute  { get; private set; }
        public double LongitudeLatidute { get; private set; }
        public string DefaultUserProfiePhoto { get; set; }
    }
}
