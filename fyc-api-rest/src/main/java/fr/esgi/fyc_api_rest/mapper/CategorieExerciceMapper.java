package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.CategorieExercice;
import fr.esgi.fyc_api_rest.dto.response.CategorieExerciceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface CategorieExerciceMapper {
    CategorieExerciceResponseDTO toResponseDTO(CategorieExercice categorieExercice);
}
