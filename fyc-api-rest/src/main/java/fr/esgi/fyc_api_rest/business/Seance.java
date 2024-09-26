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

    public Seance(Long id, String libelle, Date date, int objectifCalorique, Sportif sportif, List<Exercice> exercices) {
        this.id = id;
        this.libelle = libelle;
        this.date = date;
        this.objectifCalorique = objectifCalorique;
        this.sportif = sportif;
        this.exercices = exercices;
    }

    public Seance() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getObjectifCalorique() {
        return objectifCalorique;
    }

    public void setObjectifCalorique(int objectifCalorique) {
        this.objectifCalorique = objectifCalorique;
    }

    public Sportif getSportif() {
        return sportif;
    }

    public void setSportif(Sportif sportif) {
        this.sportif = sportif;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }
}
