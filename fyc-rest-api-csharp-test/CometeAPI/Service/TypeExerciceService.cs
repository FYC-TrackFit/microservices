using FycRestApi.Business;
using FycRestApi.Repository;
using FycRestApi.Service.Interface;

namespace FycRestApi.Service;

public class TypeExerciceService : ITypeExerciceService
{
    private readonly TypeExerciceRepository _repo;
    public TypeExerciceService(TypeExerciceRepository typeExerciceRepository)
    {
        _repo = typeExerciceRepository;
    }

    public async Task delete(int id)
    {
        await _repo.delete(id);
    }

    public async Task<List<TypeExercice>> findAll()
    {
        return await _repo.findAll();
    }

    public async Task<TypeExercice> findById(int id)
    {
        return await _repo.findById(id);
    }

    public async Task<TypeExercice> save(TypeExercice typeExercice)
    {
        return await _repo.save(typeExercice);
    }

    public async Task<TypeExercice> update(int id, TypeExercice typeExercice)
    {
        return await _repo.update(id, typeExercice);
    }
}