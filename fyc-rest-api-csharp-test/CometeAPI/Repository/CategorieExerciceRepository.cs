using FycRestApi.Business;
using FycRestApi.CustomException;

namespace FycRestApi.Repository;

public class CategorieExerciceRepository
{
    private readonly ApplicationDbContext _dbContext;

    public CategorieExerciceRepository(ApplicationDbContext dbContext)
    {
        this._dbContext = dbContext;
    }

    public async Task<CategorieExercice> save(CategorieExercice categorieExercice)
    {
        await _dbContext.CategorieExercices.AddAsync(categorieExercice);
        await _dbContext.SaveChangesAsync();
        return categorieExercice;
    }

    public async Task<CategorieExercice> findById(int id)
    {
        CategorieExercice? categorieExercice = await _dbContext.CategorieExercices.FindAsync(id);
        if (categorieExercice != null)
        {
            return categorieExercice;
        }
        else
        {
            throw new CategorieExerciceNotFoundException(id);
        }
    }
}