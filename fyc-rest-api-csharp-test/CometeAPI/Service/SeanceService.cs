using FycRestApi.Business;
using FycRestApi.Repository;
using FycRestApi.Service.Interface;

namespace FycRestApi.Service;

public class SeanceService : ISeanceService
{
    private readonly SeanceRepository _repo;
    public SeanceService(SeanceRepository seanceRepository)
    {
        _repo = seanceRepository;
    }

    public async Task delete(int id)
    {
        await _repo.delete(id);
    }

    public Task<List<Seance>> findAll()
    {
        return _repo.findAll();
    }

    public Task<Seance> findById(int id)
    {
        return _repo.findById(id);
    }

    public async Task<Seance> save(Seance seance)
    {
        return await _repo.save(seance);
    }

    public Task<Seance> update(int id, Seance seance)
    {
        return _repo.update(id, seance);
    }
}