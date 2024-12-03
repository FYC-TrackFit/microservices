namespace FycRestApi.CustomException;

public class SportifNotFoundException : KeyNotFoundException
{
    public SportifNotFoundException(int id): base($"Le sportif possédant l'id {id} n'a pas été trouvé.") { }
}