using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Mapper;
using FycRestApi.Service.Interface;
using Microsoft.AspNetCore.Mvc;

namespace FycRestApi.Rest;

[ApiController]
[Route("api/TypesExercices")]

public class TypeExerciceRestController : ControllerBase
{
    private readonly ITypeExerciceService _typeExerciceService;
    private readonly TypeExerciceMapper _typeExerciceMapper;
    public TypeExerciceRestController(ITypeExerciceService typeExerciceService, TypeExerciceMapper typeExerciceMapper)
    {
        this._typeExerciceService = typeExerciceService;
        this._typeExerciceMapper = typeExerciceMapper;
    }

    [HttpGet("")]
    public async Task<ActionResult<List<TypeExerciceResponseDTO>>> index()
    {
        List<TypeExercice> typeExercices = await this._typeExerciceService.findAll();
        return Ok(typeExercices.Select(typeExercice => _typeExerciceMapper.toDTO(typeExercice)).ToList());
    }

    [HttpPost]
    public async Task<ActionResult<TypeExerciceResponseDTO>> Create([FromBody] TypeExerciceRequestDTO requestDTO)
    {
        try
        {
            TypeExercice typeExercice = await _typeExerciceService.save(await _typeExerciceMapper.toEntity(requestDTO));
            string uri = Url.Action(action: nameof(FindById), new { id = typeExercice.id });
            return Created(uri, _typeExerciceMapper.toDTO(typeExercice));
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<TypeExerciceResponseDTO>> FindById(int id)
    {
        try
        {
            TypeExercice typeExercice = await _typeExerciceService.findById(id);
            return Ok(_typeExerciceMapper.toDTO(typeExercice));
        }
        catch (KeyNotFoundException ex)
        {
            return NotFound(ex.Message);
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpPut("{id}")]
    public async Task<ActionResult<TypeExerciceResponseDTO>> update(int id, [FromBody] TypeExerciceRequestDTO requestDTO)
    {
        try
        {
            TypeExercice typeExercice = await _typeExerciceService.update(id, await _typeExerciceMapper.toEntity(requestDTO));
            return Ok(_typeExerciceMapper.toDTO(typeExercice));
        }
        catch (KeyNotFoundException ex)
        {
            return NotFound(ex.Message);
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> delete(int id)
    {
        try
        {
            await _typeExerciceService.delete(id);
            return NoContent();
        }
        catch (KeyNotFoundException ex)
        {
            return NotFound(ex.Message);
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }
}