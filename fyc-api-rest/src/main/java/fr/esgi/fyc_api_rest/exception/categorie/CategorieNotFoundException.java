package fr.esgi.fyc_api_rest.exception.categorie;

public class CategorieNotFoundException extends RuntimeException{
    public CategorieNotFoundException(Long id){
        super("Impossible de trouver la catégorie posssédant l'id " + id);
    }
}
