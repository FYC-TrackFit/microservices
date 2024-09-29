package fr.esgi.fyc_api_rest.service;

import fr.esgi.fyc_api_rest.business.Exercice;

import java.util.List;

public interface ExerciceService {
    Exercice create(Exercice entity);

    List<Exercice> findAll();

    Exercice findById(Long id);

    Exercice update(Long id, Exercice exerciceUpdated);

    void delete(Long id);
}
