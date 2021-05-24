using Microsoft.EntityFrameworkCore;
using ReadNPassWebAPI.Domain.Entity;
using System.Linq;

namespace ReadNPassWebAPI.Data.SystemDataContext
{
    public class ReadNPassWebAPIDataContext:DbContext
    {
        public ReadNPassWebAPIDataContext(DbContextOptions options) : base(options)
        {

        }
        public ReadNPassWebAPIDataContext()
        {

        }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)



        {
            //OKA Url = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=master;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False"
            //Sedat Url = @"Data Source=DESKTOP-BQP1I0E;Initial Catalog=ReadNPassDataBase;Integrated Security=true;"
            optionsBuilder.UseSqlServer(@"Data Source=DESKTOP-BQP1I0E;Initial Catalog=ReadNPassDataBase;Integrated Security=true;");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            foreach (var relationship in modelBuilder.Model.GetEntityTypes().SelectMany(e => e.GetForeignKeys()))
            {
                relationship.DeleteBehavior = DeleteBehavior.Restrict;
            }
        }


        public DbSet<Book> Book { get; set; }
        public DbSet<BookClaim> BookClaim { get; set; }
        public DbSet<BookDetail> BookDetail { get; set; }
        public DbSet<BookPhoto> BookPhoto { get; set; }
        public DbSet<User> User { get; set; }
        public DbSet<UserLibrary> UserLibrary { get; set; }
    }
}
