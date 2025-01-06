using FycRestApi.Business;

namespace FycRestApi.Service.Interface;

public interface ICategorieExerciceService
{
    public Task<CategorieExercice> findById(int id);

    public Task<List<CategorieExercice>> findAll();
}