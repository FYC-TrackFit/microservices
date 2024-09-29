package fr.esgi.fyc_api_rest.exception.typeExercice;

public class TypeExerciceNotFoundException extends RuntimeException{
    public TypeExerciceNotFoundException(Long id){
        super("Impossible de trouver le type d'exercice posssédant l'id " + id);
    }
}
