package fr.esgi.fyc_api_rest.service.impl;

import fr.esgi.fyc_api_rest.business.Seance;
import fr.esgi.fyc_api_rest.repository.SeanceRepository;
import fr.esgi.fyc_api_rest.service.SeanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceServiceImpl(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public Seance create(Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public List<Seance> findAll() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance findById(Long id) {
        final Optional<Seance> seance = seanceRepository.findById(id);
        if(seance.isPresent()){
            return seance.get();
        }else{
            throw new RuntimeException("La seance n'existe pas");
        }
    }

    @Override
    public Seance update(Long id, Seance seanceUpdated) {
        Seance seance = findById(id);
        seance.setLibelle(seanceUpdated.getLibelle());
        seance.setDate(seanceUpdated.getDate());
        seance.setObjectifCalorique(seanceUpdated.getObjectifCalorique());
        seance.setSportif(seanceUpdated.getSportif());
        return seanceRepository.save(seance);
    }

    @Override
    public void delete(Long id) {
        if(seanceRepository.existsById(id)){
            seanceRepository.deleteById(id);
        }else{
            throw new RuntimeException("La seance n'existe pas");
        }
    }
}
