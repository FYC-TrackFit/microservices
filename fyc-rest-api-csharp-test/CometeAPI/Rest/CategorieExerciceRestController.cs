using AutoMapper;
using FycRestApi.Business;
using FycRestApi.DTO.Response;
using FycRestApi.Mapper;
using FycRestApi.Service.Interface;
using Microsoft.AspNetCore.Mvc;

[ApiController]
[Route("api/CategoriesExercices")]
public class CategorieExerciceRestController : ControllerBase
{
    private readonly ICategorieExerciceService _categorieExerciceService;
    private readonly IMapper _mapper;
    public CategorieExerciceRestController(ICategorieExerciceService categorieExerciceService, IMapper mapper)
    {
        this._categorieExerciceService = categorieExerciceService;
        this._mapper = mapper;
    }

    [HttpGet("")]
    public async Task<ActionResult<List<CategorieExerciceResponseDTO>>> Index()
    {
        List<CategorieExercice> categorieExercices = await this._categorieExerciceService.findAll();
        return Ok(_mapper.Map<List<CategorieExerciceResponseDTO>>(categorieExercices));
    }
}