import Model.ActeursEntity;
import Model.FilmsEntity;
import Model.JoueEntity;
import Util.Hibernate;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

public class Main {


    public static void main(final String[] args) throws Exception {
        final Session session = Hibernate.getSession();
        //Session session =
        try {
            System.out.println("JBoss Tools Reverse Engineering");

            @SuppressWarnings("unchecked")
            List<FilmsEntity> films= session.createQuery("from FilmsEntity").list();
            System.out.println("Les films ("+films.size()+") : ");
            for(FilmsEntity film:films)
            {
                @SuppressWarnings("unchecked")
                Set<JoueEntity> setJoues=film.getJoues();
                System.out.println(film.getCodeFilm()+ " : " + film.getTitreFilm()+ " (" + film.getAnneeFilm()+") contient " + setJoues.size()+ " acteur(s) : ");
                for(JoueEntity joue:setJoues)
                {
                    ActeursEntity acteur=joue.getActeur();
                    System.out.println("- " + acteur.getPrenomActeur()+ " " + acteur.getNomActeur()+ " dans le rôle de '" + joue.getCasting()+ "'.");

                }
            }
        } finally {
            session.close();
        }
    }
}
