package fr.esgi.fyc_api_rest.exception;

public class MissingParamException extends RuntimeException{
    public MissingParamException(){
        super("Paramètre manquant.");
    }
}
