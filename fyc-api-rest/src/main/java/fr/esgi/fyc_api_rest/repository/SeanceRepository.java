package fr.esgi.fyc_api_rest.repository;

import fr.esgi.fyc_api_rest.business.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
