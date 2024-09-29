package fr.esgi.fyc_api_rest.rest;

import fr.esgi.fyc_api_rest.business.Exercice;
import fr.esgi.fyc_api_rest.business.TypeExercice;
import fr.esgi.fyc_api_rest.dto.request.TypeExerciceRequestDTO;
import fr.esgi.fyc_api_rest.dto.response.TypeExerciceResponseDTO;
import fr.esgi.fyc_api_rest.mapper.TypeExerciceMapper;
import fr.esgi.fyc_api_rest.service.TypeExerciceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/TypesExercices")
public class TypeExerciceRestController {
    private final TypeExerciceService typeExerciceService;
    private final TypeExerciceMapper typeExerciceMapper;

    public TypeExerciceRestController(TypeExerciceService typeExerciceService, TypeExerciceMapper typeExerciceMapper) {
        this.typeExerciceService = typeExerciceService;
        this.typeExerciceMapper = typeExerciceMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TypeExerciceResponseDTO create(@RequestBody TypeExerciceRequestDTO typeExerciceCreationDTO){
        TypeExercice typeExercice =  typeExerciceService.create(typeExerciceMapper.toEntity(typeExerciceCreationDTO));
        return typeExerciceMapper.toResponseDTO(typeExercice);
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TypeExerciceResponseDTO> findAll(){
        List<TypeExercice> typesExercices = typeExerciceService.findAll();
        return typesExercices.stream().map(typeExerciceMapper::toResponseDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TypeExerciceResponseDTO findById(@PathVariable Long id){
        return typeExerciceMapper.toResponseDTO(typeExerciceService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public TypeExerciceResponseDTO update(@PathVariable Long id, @RequestBody TypeExerciceRequestDTO typeExerciceRequestDTO){
        TypeExercice typeExercice = typeExerciceService.update(id, typeExerciceMapper.toEntity(typeExerciceRequestDTO));
        return typeExerciceMapper.toResponseDTO(typeExercice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        typeExerciceService.delete(id);
    }
}
