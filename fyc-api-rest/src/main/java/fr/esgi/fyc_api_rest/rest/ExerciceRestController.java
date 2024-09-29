package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Exercice;
import fr.esgi.fyc_api_rest.dto.request.ExerciceRequestDTO;
import fr.esgi.fyc_api_rest.dto.response.ExerciceResponseDTO;
import fr.esgi.fyc_api_rest.mapper.ExerciceMapper;
import fr.esgi.fyc_api_rest.service.ExerciceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Exercices")
public class ExerciceRestController {
    private final ExerciceService exerciceService;
    private final ExerciceMapper exerciceMapper;

    public ExerciceRestController(ExerciceService exerciceService, ExerciceMapper exerciceMapper) {
        this.exerciceService = exerciceService;
        this.exerciceMapper = exerciceMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ExerciceResponseDTO create(@RequestBody ExerciceRequestDTO exerciceDTO){
        Exercice exercice = exerciceService.create(exerciceMapper.toEntity(exerciceDTO));
        return exerciceMapper.toResponseDTO(exercice);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ExerciceResponseDTO> findAll(){
        List<Exercice> exercices = exerciceService.findAll();
        return exercices.stream().map(exerciceMapper::toResponseDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ExerciceResponseDTO findById(@PathVariable Long id){
        Exercice exercice = exerciceService.findById(id);
        return exerciceMapper.toResponseDTO(exercice);
    }

    @PutMapping("/{id}")
    public ExerciceResponseDTO update(@PathVariable Long id, @RequestBody ExerciceRequestDTO exerciceDTO){
        Exercice exercice = exerciceService.update(id, exerciceMapper.toEntity(exerciceDTO));
        return exerciceMapper.toResponseDTO(exercice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        exerciceService.delete(id);
    }
}
