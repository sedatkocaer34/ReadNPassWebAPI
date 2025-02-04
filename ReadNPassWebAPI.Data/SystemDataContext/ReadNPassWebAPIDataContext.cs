﻿using Microsoft.EntityFrameworkCore;
using ReadNPassWebAPI.Domain.Entity;
using System;
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
            optionsBuilder.UseSqlServer(@"Data Source=3662884101514\SQLEXPRESS;Initial Catalog=ReadNPassDataBase;Integrated Security=true;");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            foreach (var relationship in modelBuilder.Model.GetEntityTypes().SelectMany(e => e.GetForeignKeys()))
            {
                relationship.DeleteBehavior = DeleteBehavior.Restrict;

            }
            modelBuilder.Entity<Book>()
                .HasOne<BookDetail>(c => c.BookDetail)
                .WithOne(x => x.Book).OnDelete(DeleteBehavior.Cascade);

            modelBuilder.Entity<Book>()
               .HasMany<BookPhoto>(c => c.BookPhotos)
               .WithOne(x => x.Book).OnDelete(DeleteBehavior.Cascade);

            Guid userId = Guid.NewGuid();
            modelBuilder.Entity<User>().HasData(new User
            {
                Id = userId,
                Name = "sedat",
                SurName="Kocer",
                Email= "sk@hotmail.com",
                Password="saassdasasasdasd",
                DefaultUserProfiePhoto="asdasd",
                LocationLatidute=0,
                LongitudeLatidute=0

            });

            modelBuilder.Entity<UserLibrary>().HasData(new UserLibrary 
            { 
              Id= Guid.Parse("287ec72b-05ac-4fcf-1c90-08d91304fd81"),
              LibraryName="sedat",
              UserId= userId
            });

        }


        public DbSet<Book> Book { get; set; }
        public DbSet<BookClaim> BookClaim { get; set; }
        public DbSet<BookDetail> BookDetail { get; set; }
        public DbSet<BookPhoto> BookPhoto { get; set; }
        public DbSet<User> User { get; set; }
        public DbSet<UserLibrary> UserLibrary { get; set; }
    }
}
