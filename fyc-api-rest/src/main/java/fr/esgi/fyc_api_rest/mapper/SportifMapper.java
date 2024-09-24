package fr.esgi.fyc_api_rest.mapper;

import fr.esgi.fyc_api_rest.business.Sportif;
import fr.esgi.fyc_api_rest.dto.sportif.in.SportifDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface SportifMapper {
    public Sportif toEntity(SportifDTO sportifCreationDTO);
}
