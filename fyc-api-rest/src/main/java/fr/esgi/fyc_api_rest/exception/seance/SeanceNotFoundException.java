package fr.esgi.fyc_api_rest.exception.seance;

public class SeanceNotFoundException extends RuntimeException{
    public SeanceNotFoundException(Long id){
        super("Impossible de trouver la seance "+id);
    }
}
