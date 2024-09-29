package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.TypeExercice;
import fr.esgi.fyc_api_rest.dto.typeExercice.in.TypeExerciceDTO;
import fr.esgi.fyc_api_rest.service.CategorieExerciceService;
import fr.esgi.fyc_api_rest.service.TypeExerciceService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TypeExerciceService.class, CategorieExerciceService.class}
)
public interface TypeExerciceMapper {
    @Mapping(target = "categorie", source = "idCategorie")
    public TypeExercice toEntity(TypeExerciceDTO typeExerciceCreationDTO);
}
