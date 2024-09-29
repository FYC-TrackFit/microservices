package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.TypeExercice;
import fr.esgi.fyc_api_rest.dto.request.TypeExerciceRequestDTO;
import fr.esgi.fyc_api_rest.dto.response.TypeExerciceResponseDTO;
import fr.esgi.fyc_api_rest.service.CategorieExerciceService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CategorieExerciceService.class, CategorieExerciceMapper.class}
)
public interface TypeExerciceMapper {
    @Mapping(target = "categorie", source = "idCategorie")
    public TypeExercice toEntity(TypeExerciceRequestDTO typeExerciceCreationDTO);

    @Mapping(target = "categorieExerciceResponse", source = "categorie")
    public TypeExerciceResponseDTO toResponseDTO(TypeExercice typeExercice);
}
