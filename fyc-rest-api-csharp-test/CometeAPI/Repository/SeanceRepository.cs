using FycRestApi.Business;
using FycRestApi.CustomException;
using Microsoft.EntityFrameworkCore;

namespace FycRestApi.Repository;

public class SeanceRepository
{
    private readonly ApplicationDbContext _dbContext;

    public SeanceRepository(ApplicationDbContext dbContext)
    {
        this._dbContext = dbContext;
    }

    public async Task<Seance> save(Seance seance)
    {
        await _dbContext.Seances.AddAsync(seance);
        await _dbContext.SaveChangesAsync();
        return seance;
    }

    public async Task<Seance> findById(int id)
    {
        Seance? seance = await _dbContext.Seances.Include(s => s.sportif).FirstOrDefaultAsync(s => s.id == id);
        if (seance != null)
        {
            return seance;
        }
        else
        {
            throw new SeanceNotFoundException(id);
        }
    }

    public async Task<List<Seance>> findAll()
    {
        return await _dbContext.Seances.Include(s=>s.sportif).ToListAsync();
    }

    public async Task<Seance> update(int id, Seance seanceUpdated)
    {
        Seance seance = await findById(id);
        seance.libelle = seanceUpdated.libelle;
        seance.date = seanceUpdated.date;
        seance.sportif = seanceUpdated.sportif;
        await _dbContext.SaveChangesAsync();
        return seance;
    }

    public async Task delete(int id)
    {
        Seance seance = await findById(id);
        _dbContext.Seances.Remove(seance);
        await _dbContext.SaveChangesAsync();
    }
}