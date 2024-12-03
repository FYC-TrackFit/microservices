namespace FycRestApi.DTO.Request;

public class SeanceRequestDTO
{
    public string libelle { get; set; }
    public DateTime date { get; set; }
    public int objectifCalorique { get; set; }
    public int idSportif { get; set; }
}
