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

    public async Task Delete(int id)
    {
        await _sportifRepository.Delete(id);
    }

    public async Task<List<Sportif>> FindAll()
    {
        return await _sportifRepository.FindAll();
    }

    public async Task<Sportif> FindById(int id)
    {
        return await _sportifRepository.FindById(id);
    }

    public async Task<Sportif> Save(Sportif sportif)
    {
        return await _sportifRepository.Save(sportif);
    }

    public async Task<Sportif> Update(int id, Sportif sportifUpdated)
    {
        return await _sportifRepository.Update(id, sportifUpdated);
    }
}