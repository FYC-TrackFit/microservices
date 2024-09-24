package fr.esgi.fyc_api_rest.service.impl;

import fr.esgi.fyc_api_rest.business.Sportif;
import fr.esgi.fyc_api_rest.repository.SportifRepository;
import fr.esgi.fyc_api_rest.service.SportifService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportifServiceImpl implements SportifService {
    private final SportifRepository sportifRepository;

    public SportifServiceImpl(SportifRepository sportifRepository){
        this.sportifRepository = sportifRepository;
    }

    @Override
    public Sportif create(Sportif sportif) {
        return sportifRepository.save(sportif);
    }

    @Override
    public List<Sportif> findAll() {
        return sportifRepository.findAll();
    }

    @Override
    public Sportif findById(Long id) {
        Optional<Sportif> sportif = sportifRepository.findById(id);
        if(sportif.isPresent()){
            return sportif.get();
        }else{
            throw new RuntimeException("");
        }
    }

    @Override
    public Sportif update(Long id, Sportif sportifUpdated) {
        Sportif sportif = this.findById(id);
        sportif.setNom(sportifUpdated.getNom());
        sportif.setPrenom(sportifUpdated.getPrenom());
        return sportifRepository.save(sportif);
    }

    @Override
    public void delete(Long id) {
        sportifRepository.deleteById(id);
    }
}
