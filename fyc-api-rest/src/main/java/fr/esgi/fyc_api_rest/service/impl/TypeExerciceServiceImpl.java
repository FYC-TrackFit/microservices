package fr.esgi.fyc_api_rest.service.impl;

import fr.esgi.fyc_api_rest.business.TypeExercice;
import fr.esgi.fyc_api_rest.exception.typeExercice.TypeExerciceNotFoundException;
import fr.esgi.fyc_api_rest.repository.TypeExerciceRepository;
import fr.esgi.fyc_api_rest.service.TypeExerciceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeExerciceServiceImpl implements TypeExerciceService {

    private final TypeExerciceRepository typeExerciceRepository;

    public TypeExerciceServiceImpl(TypeExerciceRepository typeExerciceRepository) {
        this.typeExerciceRepository = typeExerciceRepository;
    }

    @Override
    public List<TypeExercice> findAll() {
        return typeExerciceRepository.findAll();
    }

    @Override
    public TypeExercice findById(Long id) {
        Optional<TypeExercice> typeExercice = typeExerciceRepository.findById(id);
        if(typeExercice.isPresent()){
            return typeExercice.get();
        }else{
            throw new TypeExerciceNotFoundException(id);
        }
    }

    @Override
    public TypeExercice create(TypeExercice typeExercice) {
        return typeExerciceRepository.save(typeExercice);
    }

    @Override
    public TypeExercice update(Long id, TypeExercice typeExerciceUpdated) {
        TypeExercice typeExercice = findById(id);
        typeExercice.setLibelle(typeExerciceUpdated.getLibelle());
        typeExercice.setObjectifCalorique(typeExerciceUpdated.getObjectifCalorique());
        typeExercice.setObjectifDurre(typeExerciceUpdated.getObjectifDurre());
        typeExercice.setRepetition(typeExerciceUpdated.getRepetition());
        typeExercice.setCategorie(typeExerciceUpdated.getCategorie());
        return typeExerciceRepository.save(typeExercice);
    }

    @Override
    public void delete(Long id) {
        if(typeExerciceRepository.existsById(id)){
            typeExerciceRepository.deleteById(id);
        }else{
            throw new TypeExerciceNotFoundException(id);
        }
    }
}
