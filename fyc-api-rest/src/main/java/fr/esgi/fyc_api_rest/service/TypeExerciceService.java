package fr.esgi.fyc_api_rest.service;

import fr.esgi.fyc_api_rest.business.TypeExercice;

import java.util.List;

public interface TypeExerciceService {
    List<TypeExercice> findAll();

    TypeExercice findById(Long id);

    TypeExercice create(TypeExercice typeExercice);
}
