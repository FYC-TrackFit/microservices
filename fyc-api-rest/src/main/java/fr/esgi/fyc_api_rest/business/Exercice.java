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
}
