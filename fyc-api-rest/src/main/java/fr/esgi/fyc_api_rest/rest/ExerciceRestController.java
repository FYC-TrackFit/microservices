package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Exercice;
import fr.esgi.fyc_api_rest.dto.exercice.in.ExerciceDTO;
import fr.esgi.fyc_api_rest.mapper.ExerciceMapper;
import fr.esgi.fyc_api_rest.service.ExerciceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Exercice create(@RequestBody ExerciceDTO exerciceDTO){
        return exerciceService.create(exerciceMapper.toEntity(exerciceDTO));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Exercice> findAll(){
        return exerciceService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Exercice findById(@PathVariable Long id){
        return exerciceService.findById(id);
    }

    @PutMapping("/{id}")
    public Exercice update(@PathVariable Long id, @RequestBody ExerciceDTO exerciceDTO){
        return exerciceService.update(id, exerciceMapper.toEntity(exerciceDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        exerciceService.delete(id);
    }
}
