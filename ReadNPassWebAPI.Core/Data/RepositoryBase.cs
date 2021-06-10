using Microsoft.EntityFrameworkCore;
using ReadNPassWebAPI.Core.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;

namespace ReadNPassWebAPI.Core.Data
{
    public class RepositoryBase<TEntity, TContext> : IRepository<TEntity>
    where TEntity : class, IEntity, new()
    where TContext : DbContext, new()
    {
        public int Add(TEntity entity)
        {
            using (var context = new TContext())
            {
                var addedEntity = context.Entry(entity);
                addedEntity.State = EntityState.Added;
                return context.SaveChanges();
            }
        }

        public int AddRange(List<TEntity> entity)
        {
            using (var context = new TContext())
            {
                context.AddRange(entity);
                return context.SaveChanges();
            }
        }

        public int Delete(TEntity entity)
        {
            using (var context = new TContext())
            {
                context.Remove(entity);
                //var deletedEntity = context.Entry(entity);
                //deletedEntity.State = EntityState.Deleted;
                return context.SaveChanges();
            }
        }

        public TEntity Get(Expression<Func<TEntity, bool>> filter)
        {
            using (var context = new TContext())
            {
                return context.Set<TEntity>().FirstOrDefault(filter);
            }
        }

        public TEntity GetById(Guid Id)
        {
            using (var context = new TContext())
            {
                return context.Set<TEntity>().Find(Id);
            }
        }

        public IList<TEntity> GetList(Expression<Func<TEntity, bool>> filter = null)
        {
            using (var context = new TContext())
            {
                return context.Set<TEntity>().Where(filter).ToList();
            }
        }

        public int Update(TEntity entity)
        {
            using (var context = new TContext())
            {
                var upadteEntity = context.Entry(entity);
                upadteEntity.State = EntityState.Modified;
                return context.SaveChanges();
            }
        }
    }
}
