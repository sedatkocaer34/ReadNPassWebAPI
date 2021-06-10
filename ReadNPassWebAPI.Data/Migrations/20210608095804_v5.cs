using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace ReadNPassWebAPI.Data.Migrations
{
    public partial class v5 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_BookDetail_Book_BookId",
                table: "BookDetail");

            migrationBuilder.DropForeignKey(
                name: "FK_BookPhoto_Book_BookId",
                table: "BookPhoto");

            migrationBuilder.AddColumn<string>(
                name: "Explain",
                table: "BookClaim",
                type: "nvarchar(max)",
                nullable: true);

            migrationBuilder.AddColumn<Guid>(
                name: "senderUserId",
                table: "BookClaim",
                type: "uniqueidentifier",
                nullable: false,
                defaultValue: new Guid("00000000-0000-0000-0000-000000000000"));

            migrationBuilder.AddForeignKey(
                name: "FK_BookDetail_Book_BookId",
                table: "BookDetail",
                column: "BookId",
                principalTable: "Book",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_BookPhoto_Book_BookId",
                table: "BookPhoto",
                column: "BookId",
                principalTable: "Book",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_BookDetail_Book_BookId",
                table: "BookDetail");

            migrationBuilder.DropForeignKey(
                name: "FK_BookPhoto_Book_BookId",
                table: "BookPhoto");

            migrationBuilder.DropColumn(
                name: "Explain",
                table: "BookClaim");

            migrationBuilder.DropColumn(
                name: "senderUserId",
                table: "BookClaim");

            migrationBuilder.AddForeignKey(
                name: "FK_BookDetail_Book_BookId",
                table: "BookDetail",
                column: "BookId",
                principalTable: "Book",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_BookPhoto_Book_BookId",
                table: "BookPhoto",
                column: "BookId",
                principalTable: "Book",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
