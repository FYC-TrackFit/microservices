package fr.esgi.fyc_api_rest.business;

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
    private int repetition;
    @ManyToOne
    @JoinColumn(name = "categorie_exercice_id")
    private CategorieExercice categorie;
    @OneToMany(mappedBy = "typeExercice", cascade = CascadeType.ALL)
    private List<Exercice> exercices;
}
