package fr.esgi.fyc_api_rest.exception.sportif;

public class SportifNotFoundException extends RuntimeException{
    public SportifNotFoundException(Long id){
        super("Impossible de trouver le sportif posssédant l'id " + id);
    }
}
