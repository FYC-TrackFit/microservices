using FycRestApi.Business;
using FycRestApi.CustomException;
using Microsoft.EntityFrameworkCore;

namespace FycRestApi.Repository;

public class ExerciceRepository
{
    private readonly ApplicationDbContext _dbContext;

    public ExerciceRepository(ApplicationDbContext dbContext)
    {
        this._dbContext = dbContext;
    }

    public async Task<Exercice> save(Exercice exercice)
    {
        await _dbContext.Exercices.AddAsync(exercice);
        await _dbContext.SaveChangesAsync();
        return exercice;
    }

    public async Task<List<Exercice>> findAll()
    {
        return await _dbContext.Exercices.Include(te => te.seance).Include(te=> te.typeExercice).ToListAsync();
    }

    public async Task<Exercice> findById(int id)
    {
        Exercice? exercice = await _dbContext.Exercices.Include(te => te.seance).Include(te => te.typeExercice).FirstOrDefaultAsync(te => te.id == id);
        if (exercice != null)
        {
            return exercice;
        }
        else
        {
            throw new ExerciceNotFoundException(id);
        }
    }

    public async Task<Exercice> update(int id, Exercice exerciceUpdated)
    {
        Exercice? exercice = await findById(id);
        exercice.libelle = exerciceUpdated.libelle;
        exercice.durreRealise = exerciceUpdated.durreRealise;
        exercice.caloriePerdus = exerciceUpdated.caloriePerdus;
        exercice.seance = exerciceUpdated.seance;
        exercice.typeExercice = exerciceUpdated.typeExercice;
        await _dbContext.SaveChangesAsync();
        return exercice;
    }

    public async Task delete(int id)
    {
        Exercice exercice = await findById(id);
        _dbContext.Exercices.Remove(exercice);
        await _dbContext.SaveChangesAsync();
    }
}