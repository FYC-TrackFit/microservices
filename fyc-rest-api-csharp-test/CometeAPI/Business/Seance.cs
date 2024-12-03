namespace FycRestApi.Business;

public class Seance
{
    public int id { get; set; }
    public string libelle { get; set; }
    public DateTime date { get; set; }
    public Sportif sportif { get; set; }
    public ICollection<Exercice> Exercices { get; set; }
}