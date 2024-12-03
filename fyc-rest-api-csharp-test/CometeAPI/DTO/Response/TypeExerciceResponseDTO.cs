namespace FycRestApi.DTO.Response;
public class TypeExerciceResponseDTO
{
    public int id { get; set; }
    public string libelle { get; set; }
    public int objectifDurre { get; set; }
    public int objectifCalorique { get; set; }
    public int repetition { get; set; }
    public CategorieExerciceResponseDTO categorieExerciceResponse { get; set; }
}
