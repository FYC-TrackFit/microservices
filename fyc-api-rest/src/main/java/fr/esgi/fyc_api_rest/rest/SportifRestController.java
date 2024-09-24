package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Sportif;
import fr.esgi.fyc_api_rest.dto.sportif.in.SportifDTO;
import fr.esgi.fyc_api_rest.mapper.SportifMapper;
import fr.esgi.fyc_api_rest.service.SportifService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Sportifs")
public class SportifRestController {
    private final SportifService sportifService;
    private final SportifMapper sportifMapper;

    public SportifRestController(SportifService sportifService, SportifMapper sportifMapper){
        this.sportifService = sportifService;
        this.sportifMapper = sportifMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Sportif create(@RequestBody SportifDTO sportifCreationDTO){
        return sportifService.create(sportifMapper.toEntity(sportifCreationDTO));
    }

    @GetMapping
    @ResponseStatus(code=HttpStatus.OK)
    public List<Sportif> findAll(){
        return sportifService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public Sportif findById(@PathVariable Long id){
        return sportifService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Sportif update(@PathVariable Long id, @RequestBody SportifDTO sportifCreationDTO){
        return sportifService.update(id, sportifMapper.toEntity(sportifCreationDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        sportifService.delete(id);
    }
}
