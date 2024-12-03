using FycRestApi.Business;
using FycRestApi.Repository;
using FycRestApi.Service.Interface;

namespace FycRestApi.Service;

public class SportifService : ISportifService
{
    private readonly SportifRepository _sportifRepository;
    public SportifService(SportifRepository sportifRepository)
    {
        _sportifRepository = sportifRepository;
    }

    public async Task delete(int id)
    {
        await _sportifRepository.delete(id);
    }

    public Task<List<Sportif>> findAll()
    {
        return _sportifRepository.findAll();
    }

    public Task<Sportif> findById(int id)
    {
        return _sportifRepository.findById(id);
    }

    public async Task<Sportif> save(Sportif sportif)
    {
        return await _sportifRepository.save(sportif);
    }

    public Task<Sportif> update(int id, Sportif sportif)
    {
        return _sportifRepository.update(id, sportif);
    }
}