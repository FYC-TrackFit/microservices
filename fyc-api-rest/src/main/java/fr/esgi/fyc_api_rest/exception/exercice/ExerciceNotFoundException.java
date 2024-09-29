package fr.esgi.fyc_api_rest.exception.exercice;

public class ExerciceNotFoundException extends RuntimeException{
    public ExerciceNotFoundException(Long id){
        super("L'exercice " + id + " n'a pas été trouvé.");
    }
}
