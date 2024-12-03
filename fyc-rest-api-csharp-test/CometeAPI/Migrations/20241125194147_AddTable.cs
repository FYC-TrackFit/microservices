using System;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace FycRestApi.Migrations
{
    /// <inheritdoc />
    public partial class AddTable : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "categorie_exercice",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    libelle = table.Column<string>(type: "varchar(255)", maxLength: 255, nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_categorie_exercice", x => x.id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "sportif",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    nom = table.Column<string>(type: "varchar(100)", maxLength: 100, nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    prenom = table.Column<string>(type: "varchar(100)", maxLength: 100, nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_sportif", x => x.id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "type_exercice",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    libelle = table.Column<string>(type: "varchar(255)", maxLength: 255, nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    objectifDurre = table.Column<int>(type: "int", nullable: false),
                    objectifCalorique = table.Column<int>(type: "int", nullable: false),
                    repetition = table.Column<int>(type: "int", nullable: false),
                    categorie_exercice_id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_type_exercice", x => x.id);
                    table.ForeignKey(
                        name: "FK_type_exercice_categorie_exercice_categorie_exercice_id",
                        column: x => x.categorie_exercice_id,
                        principalTable: "categorie_exercice",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "seance",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    libelle = table.Column<string>(type: "varchar(255)", maxLength: 255, nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    date = table.Column<DateTime>(type: "datetime(6)", nullable: false),
                    sportif_id = table.Column<int>(type: "int", nullable: false),
                    Sportifid = table.Column<int>(type: "int", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_seance", x => x.id);
                    table.ForeignKey(
                        name: "FK_seance_sportif_Sportifid",
                        column: x => x.Sportifid,
                        principalTable: "sportif",
                        principalColumn: "id");
                    table.ForeignKey(
                        name: "FK_seance_sportif_sportif_id",
                        column: x => x.sportif_id,
                        principalTable: "sportif",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "exercice",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    libelle = table.Column<string>(type: "varchar(255)", maxLength: 255, nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    durreRealise = table.Column<int>(type: "int", nullable: false),
                    caloriePerdus = table.Column<int>(type: "int", nullable: false),
                    seance_id = table.Column<int>(type: "int", nullable: false),
                    type_exercice_id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_exercice", x => x.id);
                    table.ForeignKey(
                        name: "FK_exercice_seance_seance_id",
                        column: x => x.seance_id,
                        principalTable: "seance",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_exercice_type_exercice_type_exercice_id",
                        column: x => x.type_exercice_id,
                        principalTable: "type_exercice",
                        principalColumn: "id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "IX_exercice_seance_id",
                table: "exercice",
                column: "seance_id");

            migrationBuilder.CreateIndex(
                name: "IX_exercice_type_exercice_id",
                table: "exercice",
                column: "type_exercice_id");

            migrationBuilder.CreateIndex(
                name: "IX_seance_sportif_id",
                table: "seance",
                column: "sportif_id");

            migrationBuilder.CreateIndex(
                name: "IX_seance_Sportifid",
                table: "seance",
                column: "Sportifid");

            migrationBuilder.CreateIndex(
                name: "IX_type_exercice_categorie_exercice_id",
                table: "type_exercice",
                column: "categorie_exercice_id");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "exercice");

            migrationBuilder.DropTable(
                name: "seance");

            migrationBuilder.DropTable(
                name: "type_exercice");

            migrationBuilder.DropTable(
                name: "sportif");

            migrationBuilder.DropTable(
                name: "categorie_exercice");
        }
    }
}
