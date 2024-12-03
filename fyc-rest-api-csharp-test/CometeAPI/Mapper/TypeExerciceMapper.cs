using AutoMapper;
using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Service.Interface;

namespace FycRestApi.Mapper;

public class TypeExerciceMapper
{
    private readonly IMapper _mapper;
    private readonly ICategorieExerciceService _categorieExerciceService;

    public TypeExerciceMapper(IMapper mapper, ICategorieExerciceService categorieExerciceService)
    {
        this._mapper = mapper;
        this._categorieExerciceService = categorieExerciceService;
    }

    public async Task<TypeExercice> toEntity(TypeExerciceRequestDTO requestDTO)
    {
        TypeExercice typeExercice = _mapper.Map<TypeExercice>(requestDTO);
        typeExercice.categorieExercice = await _categorieExerciceService.findById(requestDTO.idCategorie);
        return typeExercice;
    }

    public TypeExerciceResponseDTO toDTO(TypeExercice typeExercice)
    {
        TypeExerciceResponseDTO typeExerciceResponseDTO = _mapper.Map<TypeExerciceResponseDTO>(typeExercice);
        typeExerciceResponseDTO.categorieExerciceResponse = _mapper.Map<CategorieExerciceResponseDTO>(typeExercice.categorieExercice);
        return typeExerciceResponseDTO;
    }
}