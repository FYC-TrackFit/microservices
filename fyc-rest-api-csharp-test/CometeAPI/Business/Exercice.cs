namespace FycRestApi.Business;

public class Exercice
{
    public int id { get; set; }
    public string libelle { get; set; }
    public int durreRealise { get; set; }
    public int caloriePerdus { get; set; }
    public Seance seance { get; set; }
    public TypeExercice typeExercice { get; set; }
}