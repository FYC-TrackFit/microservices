using AutoMapper;
using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Service.Interface;

namespace FycRestApi.Mapper;

public class SeanceMapper
{
    private readonly IMapper _mapper;
    private readonly ISportifService _sportifService;

    public SeanceMapper(IMapper mapper, ISportifService sportifService)
    {
        this._mapper = mapper;
        this._sportifService = sportifService;
    }

    public async Task<Seance> toEntity(SeanceRequestDTO requestDTO)
    {
        Seance seance = _mapper.Map<Seance>(requestDTO);
        seance.sportif = await _sportifService.findById(requestDTO.idSportif);
        return seance;
    }

    public SeanceResponseDTO toDTO(Seance entity)
    {
        SeanceResponseDTO seanceResponseDTO = _mapper.Map<SeanceResponseDTO>(entity);
        seanceResponseDTO.sportifResponse = _mapper.Map<SportifResponseDTO>(entity.sportif);
        return seanceResponseDTO;
    }
}