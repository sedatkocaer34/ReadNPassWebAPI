﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using ReadNPassWebAPI.Data.SystemDataContext;

namespace ReadNPassWebAPI.Data.Migrations
{
    [DbContext(typeof(ReadNPassWebAPIDataContext))]
    [Migration("20210506201551_v1")]
    partial class v1
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .UseIdentityColumns()
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("ProductVersion", "5.0.1");

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.Book", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<DateTime>("BookCreateDate")
                        .HasColumnType("datetime2");

                    b.Property<string>("BookName")
                        .HasColumnType("nvarchar(max)");

                    b.Property<DateTime>("BookUpdateDate")
                        .HasColumnType("datetime2");

                    b.Property<Guid?>("UserId")
                        .HasColumnType("uniqueidentifier");

                    b.Property<Guid>("UserLibraryId")
                        .HasColumnType("uniqueidentifier");

                    b.HasKey("Id");

                    b.HasIndex("UserId");

                    b.HasIndex("UserLibraryId");

                    b.ToTable("Book");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.BookClaim", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<Guid>("BookId")
                        .HasColumnType("uniqueidentifier");

                    b.Property<Guid>("UserId")
                        .HasColumnType("uniqueidentifier");

                    b.HasKey("Id");

                    b.HasIndex("BookId");

                    b.HasIndex("UserId");

                    b.ToTable("BookClaim");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.BookDetail", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("BookDescription")
                        .HasColumnType("nvarchar(max)");

                    b.Property<Guid>("BookId")
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("BookKind")
                        .HasColumnType("nvarchar(max)");

                    b.Property<double>("BookPrice")
                        .HasColumnType("float");

                    b.Property<string>("WriterName")
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.HasIndex("BookId")
                        .IsUnique();

                    b.ToTable("BookDetail");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.BookPhoto", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<Guid>("BookId")
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("BookPhotoUrl")
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.HasIndex("BookId");

                    b.ToTable("BookPhoto");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.User", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("DefaultUserProfiePhoto")
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("Email")
                        .HasColumnType("nvarchar(max)");

                    b.Property<double>("LocationLatidute")
                        .HasColumnType("float");

                    b.Property<double>("LongitudeLatidute")
                        .HasColumnType("float");

                    b.Property<string>("Name")
                        .HasColumnType("nvarchar(max)");

                    b.Property<byte[]>("PasswordHash")
                        .HasColumnType("varbinary(max)");

                    b.Property<byte[]>("PasswordSalt")
                        .HasColumnType("varbinary(max)");

                    b.Property<string>("SurName")
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.ToTable("User");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.UserLibrary", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("LibraryName")
                        .HasColumnType("nvarchar(max)");

                    b.Property<Guid>("UserId")
                        .HasColumnType("uniqueidentifier");

                    b.HasKey("Id");

                    b.HasIndex("UserId");

                    b.ToTable("UserLibrary");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.Book", b =>
                {
                    b.HasOne("ReadNPassWebAPI.Domain.Entity.User", "User")
                        .WithMany("Books")
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("ReadNPassWebAPI.Domain.Entity.UserLibrary", "UserLibrary")
                        .WithMany("Books")
                        .HasForeignKey("UserLibraryId")
                        .OnDelete(DeleteBehavior.Restrict)
                        .IsRequired();

                    b.Navigation("User");

                    b.Navigation("UserLibrary");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.BookClaim", b =>
                {
                    b.HasOne("ReadNPassWebAPI.Domain.Entity.Book", "Book")
                        .WithMany("BookClaims")
                        .HasForeignKey("BookId")
                        .OnDelete(DeleteBehavior.Restrict)
                        .IsRequired();

                    b.HasOne("ReadNPassWebAPI.Domain.Entity.User", "User")
                        .WithMany("BookClaims")
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict)
                        .IsRequired();

                    b.Navigation("Book");

                    b.Navigation("User");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.BookDetail", b =>
                {
                    b.HasOne("ReadNPassWebAPI.Domain.Entity.Book", "Book")
                        .WithOne("BookDetail")
                        .HasForeignKey("ReadNPassWebAPI.Domain.Entity.BookDetail", "BookId")
                        .OnDelete(DeleteBehavior.Restrict)
                        .IsRequired();

                    b.Navigation("Book");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.BookPhoto", b =>
                {
                    b.HasOne("ReadNPassWebAPI.Domain.Entity.Book", "Book")
                        .WithMany("BookPhotos")
                        .HasForeignKey("BookId")
                        .OnDelete(DeleteBehavior.Restrict)
                        .IsRequired();

                    b.Navigation("Book");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.UserLibrary", b =>
                {
                    b.HasOne("ReadNPassWebAPI.Domain.Entity.User", "User")
                        .WithMany("UserLibraries")
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict)
                        .IsRequired();

                    b.Navigation("User");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.Book", b =>
                {
                    b.Navigation("BookClaims");

                    b.Navigation("BookDetail");

                    b.Navigation("BookPhotos");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.User", b =>
                {
                    b.Navigation("BookClaims");

                    b.Navigation("Books");

                    b.Navigation("UserLibraries");
                });

            modelBuilder.Entity("ReadNPassWebAPI.Domain.Entity.UserLibrary", b =>
                {
                    b.Navigation("Books");
                });
#pragma warning restore 612, 618
        }
    }
}
