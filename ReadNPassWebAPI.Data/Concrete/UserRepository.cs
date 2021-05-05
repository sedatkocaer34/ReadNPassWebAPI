using ReadNPassWebAPI.Core.Data;
using ReadNPassWebAPI.Data.Interfaces;
using ReadNPassWebAPI.Data.SystemDataContext;
using ReadNPassWebAPI.Domain.Entity;

namespace ReadNPassWebAPI.Data.Concrete
{
    public class UserRepository : RepositoryBase<User, ReadNPassWebAPIDataContext>, IUserRepository
    {
    }
}
