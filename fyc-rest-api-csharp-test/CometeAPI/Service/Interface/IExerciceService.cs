using FycRestApi.Business;

namespace FycRestApi.Service.Interface;

public interface IExerciceService
{
    public Task<Exercice> save(Exercice exercice);
    public Task<Exercice> findById(int id);
    public Task<List<Exercice>> findAll();
    public Task<Exercice> update(int id, Exercice exercice);
    public Task delete(int id);
}