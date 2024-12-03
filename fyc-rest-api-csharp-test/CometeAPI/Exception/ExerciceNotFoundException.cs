namespace FycRestApi.CustomException;

public class ExerciceNotFoundException : KeyNotFoundException
{
    public ExerciceNotFoundException(int id) : base($"L'exercice possédant l'id {id} n'a pas été trouvé.") { }
}