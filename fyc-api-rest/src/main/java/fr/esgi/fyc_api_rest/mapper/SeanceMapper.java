package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.Seance;
import fr.esgi.fyc_api_rest.dto.request.SeanceRequestDTO;
import fr.esgi.fyc_api_rest.dto.response.SeanceResponseDTO;
import fr.esgi.fyc_api_rest.service.SportifService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SportifService.class, ExerciceMapper.class}
)
public interface SeanceMapper {
    @Mapping(target = "sportif", source = "idSportif")
    public Seance toEntity(SeanceRequestDTO seanceDTO);

    @Mapping(target = "sportifResponse", source = "sportif")
    @Mapping(target = "exercicesResponse", source = "exercices")
    public SeanceResponseDTO toResponseDTO(Seance seance);
}
