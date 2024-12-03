using FycRestApi.Business;
using Microsoft.EntityFrameworkCore;

public class ApplicationDbContext : DbContext
{
    public DbSet<Sportif> Sportifs { get; set; }
    public DbSet<TypeExercice> TypeExercices { get; set; }
    public DbSet<CategorieExercice> CategorieExercices { get; set; }
    public DbSet<Seance> Seances { get; set; }
    public DbSet<Exercice> Exercices { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseMySql("Server=localhost;Database=fyc;User=root;Password=fyc;",
            new MySqlServerVersion(new Version(8, 0, 21))).EnableSensitiveDataLogging()
        .LogTo(Console.WriteLine);
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        #region Sportif

        // Config Sportifs
        modelBuilder.Entity<Sportif>(entity =>
        {
            entity.ToTable("sportif");
            entity.HasKey(e => e.id);
            entity.Property(e => e.nom)
                  .IsRequired()
                  .HasMaxLength(100);
            entity.Property(e => e.prenom)
                  .IsRequired()
                  .HasMaxLength(100);
        });

        #endregion Sportif

        #region Seance

        // Config Seance
        modelBuilder.Entity<Seance>(entity =>
        {
            entity.ToTable("seance");
            entity.HasKey(e => e.id);
            entity.Property(e => e.libelle)
                  .IsRequired()
                  .HasMaxLength(255);
            entity.Property(e => e.date)
                  .IsRequired();

            entity.HasOne(e => e.sportif)
                  .WithMany()
                  .HasForeignKey("sportif_id")
                  .OnDelete(DeleteBehavior.Cascade);

            entity.HasMany(e => e.Exercices)
                  .WithOne(e => e.seance)
                  .HasForeignKey("seance_id")
                  .OnDelete(DeleteBehavior.Cascade);
        });

        #endregion Seance

        #region CategorieExercice

        // Config CategorieExercice
        modelBuilder.Entity<CategorieExercice>(entity =>
        {
            entity.ToTable("categorie_exercice");
            entity.HasKey(e => e.id);
            entity.Property(e => e.libelle)
                  .IsRequired()
                  .HasMaxLength(255);
        });

        #endregion CategorieExercice

        #region TypeExercice

        // Config TypeExercice
        modelBuilder.Entity<TypeExercice>(entity =>
        {
            entity.ToTable("type_exercice");
            entity.HasKey(e => e.id);
            entity.Property(e => e.libelle)
                  .IsRequired()
                  .HasMaxLength(255);

            entity.Property(e => e.objectifDurre).IsRequired();
            entity.Property(e => e.objectifCalorique).IsRequired();
            entity.Property(e => e.repetition).IsRequired();
            entity.HasOne(e => e.categorieExercice)
                  .WithMany()
                  .HasForeignKey("categorie_exercice_id")
                  .OnDelete(DeleteBehavior.Cascade);

            entity.HasMany(e => e.Exercices)
                  .WithOne(e => e.typeExercice)
                  .HasForeignKey("type_exercice_id")
                  .OnDelete(DeleteBehavior.Cascade);
        });

        #endregion TypeExercice

        #region Exercice

        // Config Exercice
        modelBuilder.Entity<Exercice>(entity =>
        {
            entity.ToTable("exercice");
            entity.HasKey(e => e.id);
            entity.Property(e => e.libelle)
                  .IsRequired()
                  .HasMaxLength(255);
            entity.Property(e => e.durreRealise)
                  .IsRequired();
            entity.Property(e => e.caloriePerdus)
                  .IsRequired();
        });

        #endregion Exercice
    }
}