namespace FycRestApi.DTO.Response;

public class SeanceResponseDTO
{
    public int id { get; set; }
    public string libelle { get; set; }
    public DateTime date { get; set; }
    public int objectifCalorique { get; set; }
    public SportifResponseDTO sportifResponse { get; set; }
    public List<ExerciceResponseDTO> exercicesResponse { get; set; }
}
