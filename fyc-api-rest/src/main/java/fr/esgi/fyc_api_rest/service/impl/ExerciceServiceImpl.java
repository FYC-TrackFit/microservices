package fr.esgi.fyc_api_rest.service.impl;

import fr.esgi.fyc_api_rest.business.Exercice;
import fr.esgi.fyc_api_rest.dto.exercice.in.ExerciceDTO;
import fr.esgi.fyc_api_rest.exception.exercice.ExerciceNotFoundException;
import fr.esgi.fyc_api_rest.repository.ExerciceRepository;
import fr.esgi.fyc_api_rest.service.ExerciceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciceServiceImpl implements ExerciceService {
    private final ExerciceRepository exerciceRepository;

    public ExerciceServiceImpl(ExerciceRepository exerciceRepository) {
        this.exerciceRepository = exerciceRepository;
    }

    @Override
    public Exercice create(Exercice entity) {
        return exerciceRepository.save(entity);
    }

    @Override
    public List<Exercice> findAll() {
        return exerciceRepository.findAll();
    }

    @Override
    public Exercice findById(Long id) {
        Optional<Exercice> exercice = exerciceRepository.findById(id);
        if(exercice.isPresent()){
            return exercice.get();
        }else{
            throw new ExerciceNotFoundException(id);
        }
    }

    @Override
    public Exercice update(Long id, Exercice exerciceUpdated) {
        Exercice exercice = findById(id);
        exercice.setLibelle(exerciceUpdated.getLibelle());
        exercice.setDurreRealise(exerciceUpdated.getDurreRealise());
        exercice.setCaloriePerdus(exerciceUpdated.getCaloriePerdus());
        exercice.setSeance(exerciceUpdated.getSeance());
        exercice.setTypeExercice(exerciceUpdated.getTypeExercice());
        return exerciceRepository.save(exercice);
    }

    @Override
    public void delete(Long id) {
        if(exerciceRepository.existsById(id)){
            exerciceRepository.deleteById(id);
        }else{
            throw new ExerciceNotFoundException(id);
        }
    }
}
