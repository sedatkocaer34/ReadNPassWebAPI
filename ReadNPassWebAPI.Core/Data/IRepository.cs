using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Text;

namespace ReadNPassWebAPI.Core.Data
{
    public interface IRepository<T> where T : class, IEntity, new()
    {
        T Get(Expression<Func<T, bool>> filter);
        IList<T> GetList(Expression<Func<T, bool>> filter = null);
        int Add(T entity);
        int AddRange(List<T> entity);
        int Update(T entity);
        int Delete(T entity);
        T GetById(Guid Id);
    }
}
