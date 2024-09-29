package fr.esgi.fyc_api_rest.repository;

import fr.esgi.fyc_api_rest.business.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
}
