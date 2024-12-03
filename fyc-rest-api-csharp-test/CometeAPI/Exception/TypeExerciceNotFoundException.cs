namespace FycRestApi.CustomException;

public class TypeExerciceNotFoundException : KeyNotFoundException
{
    public TypeExerciceNotFoundException(int id) : base($"Le type d'exercice possédant l'id {id} n'a pas été trouvé.") { }
}