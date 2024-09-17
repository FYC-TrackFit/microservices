package fr.esgi.fyc_api_rest.business;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategorieExercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<TypeExercice> typeExercices;

    public CategorieExercice(String libelle) {
        this.libelle = libelle;
    }
}
