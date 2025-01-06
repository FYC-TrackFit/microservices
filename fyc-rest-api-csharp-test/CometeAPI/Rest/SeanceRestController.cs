using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Mapper;
using FycRestApi.Service.Interface;
using Microsoft.AspNetCore.Mvc;

namespace FycRestApi.Rest;

[ApiController]
[Route("api/Seances")]
public class SeanceRestController : ControllerBase
{
    private readonly ISeanceService _seanceService;
    private readonly SeanceMapper _seanceMapper;
    public SeanceRestController(ISeanceService seanceService, SeanceMapper seanceMapper)
    {
        this._seanceService = seanceService;
        this._seanceMapper = seanceMapper;
    }

    [HttpGet("")]
    public async Task<ActionResult<List<SeanceResponseDTO>>> index()
    {
        List<Seance> seances = await this._seanceService.findAll();
        return Ok(seances.Select(seance => _seanceMapper.toDTO(seance)).ToList());
    }

    [HttpPost]
    public async Task<ActionResult<SeanceResponseDTO>> Create([FromBody] SeanceRequestDTO requestDTO)
    {
        try
        {
            Seance seance = await _seanceService.save(await _seanceMapper.toEntity(requestDTO));
            string uri = Url.Action(action: nameof(FindById), new { id = seance.id });
            return Created(uri, seance);
        }
        catch (Exception ex)
        {
            return BadRequest(ex.Message);
        }
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<SeanceResponseDTO>> FindById(int id)
    {
        try
        {
            Seance seance = await _seanceService.findById(id);
            return Ok(_seanceMapper.toDTO(seance));
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
    public async Task<ActionResult<SeanceResponseDTO>> update(int id, [FromBody] SeanceRequestDTO requestDTO)
    {
        try
        {
            Seance seance = await _seanceService.update(id, await _seanceMapper.toEntity(requestDTO));
            return Ok(_seanceMapper.toDTO(seance));
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
            await _seanceService.delete(id);
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