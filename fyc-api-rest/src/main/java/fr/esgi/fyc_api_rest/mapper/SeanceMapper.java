package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.Seance;
import fr.esgi.fyc_api_rest.dto.seance.in.SeanceDTO;
import fr.esgi.fyc_api_rest.service.SportifService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SportifService.class}
)
public interface SeanceMapper {
    @Mapping(target = "sportif", source = "idSportif")
    public Seance toEntity(SeanceDTO seanceDTO);
}
