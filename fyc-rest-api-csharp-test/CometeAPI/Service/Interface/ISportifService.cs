using FycRestApi.Business;

namespace FycRestApi.Service.Interface;

public interface ISportifService
{
    public Task<Sportif> Save(Sportif tag);
    public Task<Sportif> FindById(int id);
    public Task<List<Sportif>> FindAll();
    public Task<Sportif> Update(int id, Sportif sportif);
    public Task Delete(int id);
}