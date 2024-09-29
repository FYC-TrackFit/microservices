package fr.esgi.fyc_api_rest.dto.response;

import java.util.Date;
import java.util.List;

public class SeanceResponseDTO {
    public Long id;
    public String libelle;
    public Date date;
    public int objectifCalorique;
    public SportifResponseDTO sportifResponse;
    public List<ExerciceResponseDTO> exercicesResponse;
}
