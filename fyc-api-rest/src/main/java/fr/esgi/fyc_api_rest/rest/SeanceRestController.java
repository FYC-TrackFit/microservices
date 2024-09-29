package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Seance;
import fr.esgi.fyc_api_rest.dto.request.SeanceRequestDTO;
import fr.esgi.fyc_api_rest.dto.response.SeanceResponseDTO;
import fr.esgi.fyc_api_rest.mapper.SeanceMapper;
import fr.esgi.fyc_api_rest.service.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public SeanceResponseDTO create(@RequestBody SeanceRequestDTO seanceDTO){
        Seance seance = seanceService.create(seanceMapper.toEntity(seanceDTO));
        return seanceMapper.toResponseDTO(seance);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<SeanceResponseDTO> findAll(){
        List<Seance> seances = seanceService.findAll();
        return seances.stream().map(seanceMapper::toResponseDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public SeanceResponseDTO findById(@PathVariable Long id){
        Seance seance = seanceService.findById(id);
        return seanceMapper.toResponseDTO(seance);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public SeanceResponseDTO update(@PathVariable Long id, @RequestBody SeanceRequestDTO seanceDTO){
        Seance seance = seanceService.update(id, seanceMapper.toEntity(seanceDTO));
        return seanceMapper.toResponseDTO(seance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        seanceService.delete(id);
    }
}
