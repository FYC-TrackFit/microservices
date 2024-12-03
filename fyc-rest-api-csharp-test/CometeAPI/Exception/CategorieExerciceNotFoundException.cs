namespace FycRestApi.CustomException;

public class CategorieExerciceNotFoundException : KeyNotFoundException
{
    public CategorieExerciceNotFoundException(int id) : base($"La catégorie d'exercice possédant l'id {id} n'a pas été trouvé.") { }
}