using AutoMapper;
using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Service.Interface;

namespace FycRestApi.Mapper;

public class ExerciceMapper
{
    private readonly IMapper _mapper;
    private readonly SeanceMapper _seanceMapper;
    private readonly TypeExerciceMapper _typeExerciceMapper;
    private readonly ISeanceService _seanceService;
    private readonly ITypeExerciceService _typeExerciceService;

    public ExerciceMapper(IMapper mapper, SeanceMapper seanceMapper, TypeExerciceMapper typeExerciceMapper, ISeanceService seanceService, ITypeExerciceService typeExerciceService)
    {
        _mapper = mapper;
        _seanceService = seanceService;
        _typeExerciceService = typeExerciceService;
        _seanceMapper = seanceMapper;
        _typeExerciceMapper = typeExerciceMapper;
    }

    public async Task<Exercice> toEntity(ExerciceRequestDTO requestDTO)
    {
        Exercice exercice = _mapper.Map<Exercice>(requestDTO);
        exercice.seance = await _seanceService.findById(requestDTO.idSeance);
        exercice.typeExercice = await _typeExerciceService.findById(requestDTO.idTypeExercice);
        return exercice;
    }

    public ExerciceResponseDTO toDTO(Exercice entity)
    {
        ExerciceResponseDTO exerciceResponseDTO = _mapper.Map<ExerciceResponseDTO>(entity);
        exerciceResponseDTO.seanceResponse = _seanceMapper.toDTO(entity.seance);
        exerciceResponseDTO.typeExerciceResponse = _typeExerciceMapper.toDTO(entity.typeExercice);
        return exerciceResponseDTO;
    }
}