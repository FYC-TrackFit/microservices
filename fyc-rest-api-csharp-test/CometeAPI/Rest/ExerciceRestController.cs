using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Mapper;
using FycRestApi.Service.Interface;
using Microsoft.AspNetCore.Mvc;

namespace FycRestApi.Rest;

[ApiController]
[Route("api/Exercices")]

public class ExerciceRestController : ControllerBase
{
    private readonly IExerciceService _exerciceService;
    private readonly ExerciceMapper _exerciceMapper;
    public ExerciceRestController(IExerciceService exerciceService, ExerciceMapper exerciceMapper)
    {
        this._exerciceService = exerciceService;
        this._exerciceMapper = exerciceMapper;
    }

    [HttpGet("")]
    public async Task<ActionResult<List<ExerciceResponseDTO>>> index()
    {
        List<Exercice> exercices = await this._exerciceService.findAll();
        return Ok(exercices.Select(exercice => _exerciceMapper.toDTO(exercice)).ToList());
    }

    [HttpPost]
    public async Task<ActionResult<ExerciceResponseDTO>> Create([FromBody] ExerciceRequestDTO requestDTO)
    {
        try
        {
            Exercice exercice = await _exerciceService.save(await _exerciceMapper.toEntity(requestDTO));
            string uri = Url.Action(action: nameof(FindById), new { id = exercice.id });
            return Created(uri, exercice);
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<ExerciceResponseDTO>> FindById(int id)
    {
        try
        {
            Exercice exercice = await _exerciceService.findById(id);
            return Ok(_exerciceMapper.toDTO(exercice));
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
    public async Task<ActionResult<ExerciceResponseDTO>> update(int id, [FromBody] ExerciceRequestDTO requestDTO)
    {
        try
        {
            Exercice exercice = await _exerciceService.update(id, await _exerciceMapper.toEntity(requestDTO));
            return Ok(_exerciceMapper.toDTO(exercice));
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
            await _exerciceService.delete(id);
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