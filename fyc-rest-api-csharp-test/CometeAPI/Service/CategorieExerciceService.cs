using FycRestApi.Business;
using FycRestApi.Repository;
using FycRestApi.Service.Interface;

namespace FycRestApi.Service;

public class CategorieExerciceService : ICategorieExerciceService
{
    private readonly CategorieExerciceRepository _categorieExerciceRepository;

    public CategorieExerciceService(CategorieExerciceRepository categorieExerciceRepository)
    {
        this._categorieExerciceRepository = categorieExerciceRepository;
    }

    public async Task<CategorieExercice> findById(int id)
    {
        return await _categorieExerciceRepository.findById(id);
    }
}