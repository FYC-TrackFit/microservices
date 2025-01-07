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

    public Task<List<Sportif>> FindAll()
    {
        return _sportifRepository.FindAll();
    }

    public Task<Sportif> FindById(int id)
    {
        return _sportifRepository.FindById(id);
    }

    public async Task<Sportif> Save(Sportif sportif)
    {
        return await _sportifRepository.Save(sportif);
    }

    public Task<Sportif> Update(int id, Sportif sportif)
    {
        return _sportifRepository.Update(id, sportif);
    }
}