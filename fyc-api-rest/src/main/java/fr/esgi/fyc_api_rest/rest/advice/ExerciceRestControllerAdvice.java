package fr.esgi.fyc_api_rest.rest.advice;

import fr.esgi.fyc_api_rest.exception.exercice.ExerciceNotFoundException;
import fr.esgi.fyc_api_rest.exception.seance.SeanceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExerciceRestControllerAdvice {
    @ExceptionHandler(ExerciceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExerciceNotFoundException(ExerciceNotFoundException e){
        return e.getMessage();
    }
}
