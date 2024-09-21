package fr.esgi.fyc_api_rest.business;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TypeExercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int objectifDurre;
    private int objectifCalorique;
    private Integer repetition;
    @ManyToOne
    @JoinColumn(name = "categorie_exercice_id")
    @JsonManagedReference
    private CategorieExercice categorie;
    @OneToMany(mappedBy = "typeExercice", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Exercice> exercices;

    public TypeExercice(String libelle, int objectifDurre, int objectifCalorique, Integer repetition, CategorieExercice categorie) {
        this.libelle = libelle;
        this.objectifDurre = objectifDurre;
        this.objectifCalorique = objectifCalorique;
        this.repetition = repetition;
        this.categorie = categorie;
    }

    public TypeExercice(Long id, String libelle, int objectifDurre, int objectifCalorique, Integer repetition, CategorieExercice categorie, List<Exercice> exercices) {
        this.id = id;
        this.libelle = libelle;
        this.objectifDurre = objectifDurre;
        this.objectifCalorique = objectifCalorique;
        this.repetition = repetition;
        this.categorie = categorie;
        this.exercices = exercices;
    }

    public TypeExercice(){}

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

    public int getObjectifDurre() {
        return objectifDurre;
    }

    public void setObjectifDurre(int objectifDurre) {
        this.objectifDurre = objectifDurre;
    }

    public int getObjectifCalorique() {
        return objectifCalorique;
    }

    public void setObjectifCalorique(int objectifCalorique) {
        this.objectifCalorique = objectifCalorique;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

    public CategorieExercice getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieExercice categorie) {
        this.categorie = categorie;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }
}
