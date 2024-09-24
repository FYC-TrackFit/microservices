package fr.esgi.fyc_api_rest.service;

import fr.esgi.fyc_api_rest.business.Sportif;

import java.util.List;

public interface SportifService {
    Sportif create(Sportif sportif);
    List<Sportif> findAll();
    Sportif findById(Long id);
    Sportif update(Long id, Sportif sportif);
    void delete(Long id);
}
