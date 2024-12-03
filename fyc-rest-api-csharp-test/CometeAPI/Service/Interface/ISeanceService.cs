using FycRestApi.Business;

namespace FycRestApi.Service.Interface;

public interface ISeanceService
{
    public Task<Seance> save(Seance seance);
    public Task<Seance> findById(int id);
    public Task<List<Seance>> findAll();
    public Task<Seance> update(int id, Seance seance);
    public Task delete(int id);
}