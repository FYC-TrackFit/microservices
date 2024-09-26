package fr.esgi.fyc_api_rest.service;

import fr.esgi.fyc_api_rest.business.Seance;

import java.util.List;

public interface SeanceService {
    Seance create(Seance seance);
    List<Seance> findAll();
    Seance findById(Long id);

    void delete(Long id);

    Seance update(Long id, Seance entity);
}
