using FycRestApi.Business;
using FycRestApi.Repository;
using FycRestApi.Service.Interface;

namespace FycRestApi.Service;

public class ExerciceService : IExerciceService
{
    private readonly ExerciceRepository _exerciceRepository;
    public ExerciceService(ExerciceRepository exerciceRepository)
    {
        _exerciceRepository = exerciceRepository;
    }

    public async Task delete(int id)
    {
        await _exerciceRepository.delete(id);
    }

    public async Task<List<Exercice>> findAll()
    {
        return await _exerciceRepository.findAll();
    }

    public async Task<Exercice> findById(int id)
    {
        return await _exerciceRepository.findById(id);
    }

    public async Task<Exercice> save(Exercice exercice)
    {
        return await _exerciceRepository.save(exercice);
    }

    public async Task<Exercice> update(int id, Exercice exercice)
    {
        return await _exerciceRepository.update(id, exercice);
    }
}