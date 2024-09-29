package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Sportif;
import fr.esgi.fyc_api_rest.dto.request.SportifRequestDTO;
import fr.esgi.fyc_api_rest.dto.response.SportifResponseDTO;
import fr.esgi.fyc_api_rest.mapper.SportifMapper;
import fr.esgi.fyc_api_rest.service.SportifService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public SportifResponseDTO create(@RequestBody SportifRequestDTO sportifDTO){
        Sportif sportif = sportifService.create(sportifMapper.toEntity(sportifDTO));
        return sportifMapper.toResponseDTO(sportif);
    }

    @GetMapping
    @ResponseStatus(code=HttpStatus.OK)
    public List<SportifResponseDTO> findAll(){
        List<Sportif> sportifs = sportifService.findAll();
        return sportifs.stream().map(sportifMapper::toResponseDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public SportifResponseDTO findById(@PathVariable Long id){
        Sportif sportif = sportifService.findById(id);
        return sportifMapper.toResponseDTO(sportif);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public SportifResponseDTO update(@PathVariable Long id, @RequestBody SportifRequestDTO sportifCreationDTO){
        Sportif sportif = sportifService.update(id, sportifMapper.toEntity(sportifCreationDTO));
        return sportifMapper.toResponseDTO(sportif);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        sportifService.delete(id);
    }
}
