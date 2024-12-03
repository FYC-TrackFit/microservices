namespace FycRestApi.DTO.Response;

public class ExerciceResponseDTO
{
    public int id { get; set; }
    public string libelle { get; set; }
    public int durreRealise { get; set; }
    public int caloriePerdus { get; set; }
    public SeanceResponseDTO seanceResponse { get; set; }
    public TypeExerciceResponseDTO typeExerciceResponse { get; set; }
}
