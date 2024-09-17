package fr.esgi.fyc_api_rest.business;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sportif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy = "sportif", cascade = CascadeType.ALL)
    private List<Seance> seances;
}
