package fr.esgi.fyc_api_rest.rest.advice;

import fr.esgi.fyc_api_rest.exception.seance.SeanceNotFoundException;
import fr.esgi.fyc_api_rest.exception.sportif.SportifNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeanceRestControllerAdvice {
    @ExceptionHandler(SeanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleSeanceNotFoundException(SeanceNotFoundException e){
        return e.getMessage();
    }
}
