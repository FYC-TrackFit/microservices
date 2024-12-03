namespace FycRestApi.CustomException;

public class SeanceNotFoundException : KeyNotFoundException
{
    public SeanceNotFoundException(int id) : base($"La seance possédant l'id {id} n'a pas été trouvé.") { }
}