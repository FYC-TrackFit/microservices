using FycRestApi.Business;
using FycRestApi.CustomException;
using Microsoft.EntityFrameworkCore;

namespace FycRestApi.Repository;

public class TypeExerciceRepository
{
    private readonly ApplicationDbContext _dbContext;

    public TypeExerciceRepository(ApplicationDbContext dbContext) 
    {
        this._dbContext = dbContext;
    }

    public async Task<TypeExercice> save(TypeExercice typeExercice)
    {
        await _dbContext.TypeExercices.AddAsync(typeExercice);
        await _dbContext.SaveChangesAsync();
        return typeExercice;
    }

    public async Task<List<TypeExercice>> findAll()
    {
        return await _dbContext.TypeExercices.Include(te => te.categorieExercice).ToListAsync();
    }

    public async Task<TypeExercice> findById(int id)
    {
        TypeExercice? typeExercice = await _dbContext.TypeExercices.Include(te => te.categorieExercice).FirstOrDefaultAsync(te=> te.id == id);
        if (typeExercice != null)
        {
            return typeExercice;
        }
        else
        {
            throw new TypeExerciceNotFoundException(id);
        }
    }

    public async Task<TypeExercice> update(int id, TypeExercice typeExercieUpdated)
    {
        TypeExercice? typeExercice = await findById(id);
        typeExercice.libelle = typeExercieUpdated.libelle;
        typeExercice.objectifDurre = typeExercieUpdated.objectifDurre;
        typeExercice.objectifCalorique = typeExercieUpdated.objectifCalorique;
        typeExercice.repetition = typeExercieUpdated.repetition;
        typeExercice.categorieExercice = typeExercieUpdated.categorieExercice;
        await _dbContext.SaveChangesAsync();
        return typeExercice;
    }

    public async Task delete(int id)
    {
        TypeExercice typeExercice = await findById(id);
        _dbContext.TypeExercices.Remove(typeExercice);
        await _dbContext.SaveChangesAsync();
    }
}