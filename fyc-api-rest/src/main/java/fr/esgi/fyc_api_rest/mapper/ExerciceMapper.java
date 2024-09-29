package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.Exercice;
import fr.esgi.fyc_api_rest.dto.exercice.in.ExerciceDTO;
import fr.esgi.fyc_api_rest.service.SeanceService;
import fr.esgi.fyc_api_rest.service.SportifService;
import fr.esgi.fyc_api_rest.service.TypeExerciceService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SeanceService.class, TypeExerciceService.class}
)
public interface ExerciceMapper {
    @Mapping(target = "seance", source = "idSeance")
    @Mapping(target = "typeExercice", source = "idTypeExercice")
    Exercice toEntity(ExerciceDTO exerciceDTO);
}
