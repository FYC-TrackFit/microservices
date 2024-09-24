package fr.esgi.fyc_api_rest.repository;

import fr.esgi.fyc_api_rest.business.Sportif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportifRepository extends JpaRepository<Sportif, Long> {

}
