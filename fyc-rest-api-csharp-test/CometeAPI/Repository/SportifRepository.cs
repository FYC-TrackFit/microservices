using FycRestApi.Business;
using FycRestApi.CustomException;
using Microsoft.EntityFrameworkCore;

namespace FycRestApi.Repository;

public class SportifRepository
{
    private readonly ApplicationDbContext _dbContext;

    public SportifRepository(ApplicationDbContext dbContext)
    {
        this._dbContext = dbContext;
    }

    public async Task<Sportif> save(Sportif sportif)
    {
        await _dbContext.Sportifs.AddAsync(sportif);
        await _dbContext.SaveChangesAsync();
        return sportif;
    }

    public async Task<Sportif> findById(int id)
    {
        Sportif? sportif = await _dbContext.Sportifs.FindAsync(id);
        if (sportif != null) {
            return sportif;
        }
        else
        {
            throw new SportifNotFoundException(id);
        }
    }

    public async Task<List<Sportif>> findAll()
    {
        return await _dbContext.Sportifs.ToListAsync();
    }

    public async Task<Sportif> update(int id, Sportif sportifUpdated)
    {
        Sportif sportif = await findById(id);
        sportif.nom = sportifUpdated.nom;
        sportif.prenom = sportifUpdated.prenom;
        await _dbContext.SaveChangesAsync();
        return sportif;
    }

    public async Task delete(int id)
    {
        Sportif sportif = await findById(id);
        _dbContext.Sportifs.Remove(sportif);
        await _dbContext.SaveChangesAsync();
    }
}