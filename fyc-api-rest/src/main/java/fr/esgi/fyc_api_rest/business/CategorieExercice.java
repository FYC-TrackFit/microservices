package fr.esgi.fyc_api_rest.business;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategorieExercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<TypeExercice> typeExercices;

    public CategorieExercice() {
    }

    public CategorieExercice(Long id, String libelle, List<TypeExercice> typeExercices) {
        this.id = id;
        this.libelle = libelle;
        this.typeExercices = typeExercices;
    }

    public CategorieExercice(String libelle) {
        this.libelle = libelle;
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

    public List<TypeExercice> getTypeExercices() {
        return typeExercices;
    }

    public void setTypeExercices(List<TypeExercice> typeExercices) {
        this.typeExercices = typeExercices;
    }
}
