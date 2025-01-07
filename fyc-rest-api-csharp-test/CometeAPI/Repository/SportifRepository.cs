using FycRestApi.Business;
using FycRestApi.CustomException;
using Microsoft.EntityFrameworkCore;

namespace FycRestApi.Repository;

public class SportifRepository
{
    private readonly ApplicationDbContext _dbContext;

    public SportifRepository(ApplicationDbContext context)
    {
        _dbContext = context;
    }

    public async Task<Sportif> Save(Sportif sportif)
    {
        await _dbContext.Sportifs.AddAsync(sportif);
        await _dbContext.SaveChangesAsync();
        return sportif;
    }

    public async Task<Sportif> FindById(int id)
    {
        Sportif? sportif = await _dbContext.Sportifs.FindAsync(id);
        if(sportif != null)
        {
            return sportif;
        }
        else
        {
            throw new SportifNotFoundException(id);
        }
    }

    public async Task<List<Sportif>> FindAll()
    {
        return await _dbContext.Sportifs.ToListAsync();
    }

    public async Task<Sportif> Update(int id, Sportif sportifUpdated)
    {
        Sportif sportif = await FindById(id);
        sportif.nom = sportifUpdated.nom;
        sportif.prenom = sportifUpdated.prenom;
        await _dbContext.SaveChangesAsync();
        return sportif;
    }

    public async Task Delete(int id)
    {
        Sportif sportif = await FindById(id);
        _dbContext.Sportifs.Remove(sportif);
        await _dbContext.SaveChangesAsync();
    }
}