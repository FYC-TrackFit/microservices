package fr.esgi.fyc_api_rest.business;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private Date date;
    private int objectifCalorique;
    @ManyToOne
    @JoinColumn(name = "sportif_id")
    private Sportif sportif;
    @OneToMany(mappedBy = "seance", cascade = CascadeType.ALL)
    private List<Exercice> exercices;
}
