package fr.esgi.fyc_api_rest.business;

import jakarta.persistence.*;

@Entity
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int durreRealise;
    private int caloriePerdus;
    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;
    @ManyToOne
    @JoinColumn(name = "type_exercice_id")
    private TypeExercice typeExercice;

    public Exercice() {
    }

    public Exercice(Long id, String libelle, int durreRealise, int caloriePerdus, Seance seance, TypeExercice typeExercice) {
        this.id = id;
        this.libelle = libelle;
        this.durreRealise = durreRealise;
        this.caloriePerdus = caloriePerdus;
        this.seance = seance;
        this.typeExercice = typeExercice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getDurreRealise() {
        return durreRealise;
    }

    public void setDurreRealise(int durreRealise) {
        this.durreRealise = durreRealise;
    }

    public int getCaloriePerdus() {
        return caloriePerdus;
    }

    public void setCaloriePerdus(int caloriePerdus) {
        this.caloriePerdus = caloriePerdus;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public TypeExercice getTypeExercice() {
        return typeExercice;
    }

    public void setTypeExercice(TypeExercice typeExercice) {
        this.typeExercice = typeExercice;
    }
}
