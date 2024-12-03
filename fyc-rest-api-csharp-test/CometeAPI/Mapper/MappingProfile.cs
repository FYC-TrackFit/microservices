using AutoMapper;
using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;

public class MappingProfile : Profile
{
    public MappingProfile()
    {
        CreateMap<SportifRequestDTO, Sportif>();
        CreateMap<Sportif, SportifResponseDTO>();

        CreateMap<CategorieExercice, CategorieExerciceResponseDTO>();

        CreateMap<TypeExerciceRequestDTO, TypeExercice>();
        CreateMap<TypeExercice, TypeExerciceResponseDTO>();

        CreateMap<SeanceRequestDTO, Seance>();
        CreateMap<Seance, SeanceResponseDTO>();

        CreateMap<ExerciceRequestDTO, Exercice>();
        CreateMap<Exercice, ExerciceResponseDTO>();
    }
}
