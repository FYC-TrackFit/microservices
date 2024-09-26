package fr.esgi.fyc_api_rest.initialisation;

import fr.esgi.fyc_api_rest.business.CategorieExercice;
import fr.esgi.fyc_api_rest.business.Sportif;
import fr.esgi.fyc_api_rest.business.TypeExercice;
import fr.esgi.fyc_api_rest.repository.CategorieExerciceRepository;
import fr.esgi.fyc_api_rest.repository.SportifRepository;
import fr.esgi.fyc_api_rest.repository.TypeExerciceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AjoutDonneesInitiales implements CommandLineRunner {
    private final CategorieExerciceRepository categorieExerciceRepository;
    private final TypeExerciceRepository typeExerciceRepository;
    private final SportifRepository sportifRepository;
    public AjoutDonneesInitiales(CategorieExerciceRepository categorieExerciceRepository, TypeExerciceRepository typeExerciceRepository, SportifRepository sportifRepository){
        this.categorieExerciceRepository = categorieExerciceRepository;
        this.typeExerciceRepository = typeExerciceRepository;
        this.sportifRepository = sportifRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addCategoriesExerciceAndTypesExercice();
        addSportifs();
    }

    private void addCategoriesExerciceAndTypesExercice() {
        CategorieExercice cardio = new CategorieExercice("Cardio");
        CategorieExercice renforcement = new CategorieExercice("Renforcement");
        CategorieExercice flexibilite = new CategorieExercice("Flexibilité");
        CategorieExercice equilibre = new CategorieExercice("Équilibre");

        List<CategorieExercice> categories = Arrays.asList(cardio, renforcement, flexibilite, equilibre);

        categories.forEach(categorieExerciceRepository::save);

        List<TypeExercice> exercicesCardio = Arrays.asList(
                new TypeExercice("Course à pied", 15, 1500, null, cardio),
                new TypeExercice("Cyclisme", 30, 600, null, cardio),
                new TypeExercice("Natation", 20, 400, null, cardio)
        );

        List<TypeExercice> exercicesRenforcement = Arrays.asList(
                new TypeExercice("Pompes", 10, 100, null, renforcement),
                new TypeExercice("Squats", 15, 200, null, renforcement),
                new TypeExercice("Gainage", 5, 50, null, renforcement)
        );

        List<TypeExercice> exercicesFlexibilite = Arrays.asList(
                new TypeExercice("Yoga", 60, 300, null, flexibilite),
                new TypeExercice("Étirements", 20, 100, null, flexibilite)
        );

        List<TypeExercice> exercicesEquilibre = Arrays.asList(
                new TypeExercice("Équilibre sur une jambe", 5, 50, null, equilibre),
                new TypeExercice("Tai Chi", 30, 200, null, equilibre)
        );

        List<TypeExercice> tousLesExercices = new ArrayList<>();
        tousLesExercices.addAll(exercicesCardio);
        tousLesExercices.addAll(exercicesRenforcement);
        tousLesExercices.addAll(exercicesFlexibilite);
        tousLesExercices.addAll(exercicesEquilibre);

        tousLesExercices.forEach(typeExerciceRepository::save);
    }

    public void addSportifs(){
        Sportif sportif = new Sportif("Peignet", "Robin");
        sportifRepository.save(sportif);
    }
}
