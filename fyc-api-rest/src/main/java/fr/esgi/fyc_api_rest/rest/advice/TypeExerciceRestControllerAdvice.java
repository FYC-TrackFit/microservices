package fr.esgi.fyc_api_rest.rest.advice;

import fr.esgi.fyc_api_rest.exception.typeExercice.TypeExerciceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TypeExerciceRestControllerAdvice {
    @ExceptionHandler(TypeExerciceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleMissingParamException(TypeExerciceNotFoundException e){
        return e.getMessage();
    }
}