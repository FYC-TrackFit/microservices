package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.TypeExercice;
import fr.esgi.fyc_api_rest.dto.typeExercice.in.TypeExerciceCreationDTO;
import fr.esgi.fyc_api_rest.mapper.TypeExerciceMapper;
import fr.esgi.fyc_api_rest.service.TypeExerciceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TypesExercice")
public class TypeExerciceRestController {
    private final TypeExerciceService typeExerciceService;
    private final TypeExerciceMapper typeExerciceMapper;

    public TypeExerciceRestController(TypeExerciceService typeExerciceService, TypeExerciceMapper typeExerciceMapper) {
        this.typeExerciceService = typeExerciceService;
        this.typeExerciceMapper = typeExerciceMapper;
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TypeExercice> findAll(){
        return typeExerciceService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TypeExercice findById(@PathVariable Long id){
        return typeExerciceService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TypeExercice create(@RequestBody TypeExerciceCreationDTO typeExerciceCreationDTO){
        return typeExerciceService.create(typeExerciceMapper.toEntity(typeExerciceCreationDTO));
    }
}
