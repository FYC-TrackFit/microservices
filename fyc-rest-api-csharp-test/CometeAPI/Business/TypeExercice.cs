namespace FycRestApi.Business;

public class TypeExercice
{
    public int id { get; set; }
    public string libelle { get; set; }
    public int objectifDurre { get; set; }
    public int objectifCalorique { get; set; }
    public int repetition { get; set; }
    public CategorieExercice categorieExercice { get; set; }
    public ICollection<Exercice> Exercices { get; set; }
}