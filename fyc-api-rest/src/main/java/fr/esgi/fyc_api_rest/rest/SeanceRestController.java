package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Seance;
import fr.esgi.fyc_api_rest.dto.seance.in.SeanceDTO;
import fr.esgi.fyc_api_rest.mapper.SeanceMapper;
import fr.esgi.fyc_api_rest.service.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Seances")
public class SeanceRestController {
    private final SeanceMapper seanceMapper;
    private final SeanceService seanceService;

    public SeanceRestController(SeanceMapper seanceMapper, SeanceService seanceService) {
        this.seanceMapper = seanceMapper;
        this.seanceService = seanceService;
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Seance create(@RequestBody SeanceDTO seanceDTO){
        return seanceService.create(seanceMapper.toEntity(seanceDTO));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Seance> findAll(){
        return seanceService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Seance findById(@PathVariable Long id){
        return seanceService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Seance update(@PathVariable Long id, @RequestBody SeanceDTO seanceDTO){
        return seanceService.update(id, seanceMapper.toEntity(seanceDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        seanceService.delete(id);
    }
}
