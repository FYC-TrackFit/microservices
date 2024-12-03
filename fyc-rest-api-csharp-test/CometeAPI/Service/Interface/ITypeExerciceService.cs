using FycRestApi.Business;

namespace FycRestApi.Service.Interface;

public interface ITypeExerciceService
{
    public Task<TypeExercice> save(TypeExercice typeExercice);
    public Task<TypeExercice> findById(int id);
    public Task<List<TypeExercice>> findAll();
    public Task<TypeExercice> update(int id, TypeExercice typeExercice);
    public Task delete(int id);
}