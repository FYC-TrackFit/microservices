namespace FycRestApi.DTO.Request;

public class TypeExerciceRequestDTO
{
    public string libelle { get; set; }
    public int objectifDurre { get; set; }
    public int objectifCalorique { get; set; }
    public int repetition { get; set; }
    public int idCategorie { get; set; }
}
