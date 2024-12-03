using FycRestApi.Business;

namespace FycRestApi.Service.Interface;

public interface ISportifService
{
    public Task<Sportif> save(Sportif tag);
    public Task<Sportif> findById(int id);
    public Task<List<Sportif>> findAll();
    public Task<Sportif> update(int id, Sportif sportif);
    public Task delete(int id);
}