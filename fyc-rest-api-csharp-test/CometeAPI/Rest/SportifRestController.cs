using AutoMapper;
using FycRestApi.Business;
using FycRestApi.DTO.Request;
using FycRestApi.DTO.Response;
using FycRestApi.Service.Interface;
using Microsoft.AspNetCore.Mvc;

namespace FycRestApi.Rest;

[ApiController]
[Route("api/Sportifs")]

public class SportifRestController : ControllerBase
{
    private readonly ISportifService _sportifService;
    private readonly IMapper _mapper;
    public SportifRestController(ISportifService sportifService, IMapper mapper)
    {
        this._sportifService = sportifService;
        this._mapper = mapper;
    }

    [HttpGet("")]
    public async Task<ActionResult<List<SportifResponseDTO>>> Index()
    {
        List<Sportif> sportifs = await this._sportifService.FindAll();
        return Ok(_mapper.Map<List<SportifResponseDTO>>(sportifs));
    }

    [HttpPost]
    public async Task<ActionResult<SportifResponseDTO>> Create([FromBody] SportifRequestDTO requestDTO)
    {
        try
        {
            Sportif sportif = await _sportifService.Save(_mapper.Map<Sportif>(requestDTO));
            string uri = Url.Action(action: nameof(FindById), new { id = sportif.id });
            return Created(uri, sportif);
        }
        catch (Exception ex) {
            return BadRequest(ex.Message);
        }
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<SportifResponseDTO>> FindById(int id)
    {
        try
        {
            Sportif sportif = await _sportifService.FindById(id);
            return Ok(_mapper.Map<SportifResponseDTO>(sportif));
        }
        catch (KeyNotFoundException ex)
        {
            return NotFound(ex.Message);
        }
        catch (Exception ex) {
            return BadRequest(ex.Message);
        }
    }

    [HttpPut("{id}")]
    public async Task<ActionResult<SportifResponseDTO>> Update(int id, [FromBody] SportifRequestDTO requestDTO)
    {
        try
        {
            Sportif sportif = await _sportifService.Update(id, _mapper.Map<Sportif>(requestDTO));
            return Ok(_mapper.Map<SportifResponseDTO>(sportif));
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
    public async Task<IActionResult> Delete(int id)
    {
        try
        {
            await _sportifService.Delete(id);
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