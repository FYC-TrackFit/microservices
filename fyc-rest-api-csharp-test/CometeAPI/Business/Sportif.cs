namespace FycRestApi.Business;

public class Sportif
{
    public int id { get; set; }
    public string nom { get; set; }
    public string prenom { get; set; }
    public ICollection<Seance> seances { get; set; }
}