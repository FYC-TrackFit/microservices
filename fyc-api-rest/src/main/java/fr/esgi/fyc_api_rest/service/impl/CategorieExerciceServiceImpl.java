package fr.esgi.fyc_api_rest.service.impl;

import fr.esgi.fyc_api_rest.business.CategorieExercice;
import fr.esgi.fyc_api_rest.repository.CategorieExerciceRepository;
import fr.esgi.fyc_api_rest.service.CategorieExerciceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieExerciceServiceImpl implements CategorieExerciceService {
    private final CategorieExerciceRepository categorieExerciceRepository;

    public CategorieExerciceServiceImpl(CategorieExerciceRepository categorieExerciceRepository) {
        this.categorieExerciceRepository = categorieExerciceRepository;
    }

    @Override
    public CategorieExercice findById(Long id) {
        Optional<CategorieExercice> categorieExercice = categorieExerciceRepository.findById(id);
        if(categorieExercice.isPresent()){
            return categorieExercice.get();
        }else{
            throw new RuntimeException("");
        }
    }
}
