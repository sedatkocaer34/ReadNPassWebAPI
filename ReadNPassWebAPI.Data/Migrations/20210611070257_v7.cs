using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace ReadNPassWebAPI.Data.Migrations
{
    public partial class v7 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "User",
                columns: new[] { "Id", "DefaultUserProfiePhoto", "Email", "LocationLatidute", "LongitudeLatidute", "Name", "Password", "SurName" },
                values: new object[] { new Guid("d8fd1601-84fa-4102-b9c3-975111d2e725"), "asdasd", "sk@hotmail.com", 0.0, 0.0, "sedat", "saassdasasasdasd", "Kocer" });

            migrationBuilder.InsertData(
                table: "UserLibrary",
                columns: new[] { "Id", "LibraryName", "UserId" },
                values: new object[] { new Guid("287ec72b-05ac-4fcf-1c90-08d91304fd81"), "sedat", new Guid("d8fd1601-84fa-4102-b9c3-975111d2e725") });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "UserLibrary",
                keyColumn: "Id",
                keyValue: new Guid("287ec72b-05ac-4fcf-1c90-08d91304fd81"));

            migrationBuilder.DeleteData(
                table: "User",
                keyColumn: "Id",
                keyValue: new Guid("d8fd1601-84fa-4102-b9c3-975111d2e725"));
        }
    }
}
