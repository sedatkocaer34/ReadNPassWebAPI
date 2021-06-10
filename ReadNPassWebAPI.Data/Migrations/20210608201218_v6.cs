using Microsoft.EntityFrameworkCore.Migrations;

namespace ReadNPassWebAPI.Data.Migrations
{
    public partial class v6 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<bool>(
                name: "IsSales",
                table: "BookClaim",
                type: "bit",
                nullable: false,
                defaultValue: false);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "IsSales",
                table: "BookClaim");
        }
    }
}
