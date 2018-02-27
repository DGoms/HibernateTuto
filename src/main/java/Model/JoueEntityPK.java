package Model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class JoueEntityPK implements Serializable {
    private FilmsEntity film;
    private ActeursEntity acteur;

    @ManyToOne
    public FilmsEntity getFilm() {
        return film;
    }

    public void setFilm(FilmsEntity film) {
        this.film = film;
    }

    @ManyToOne
    public ActeursEntity getActeur() {
        return acteur;
    }

    public void setActeur(ActeursEntity acteur) {
        this.acteur = acteur;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JoueEntityPK that = (JoueEntityPK) o;

        if (film != null ? !film.equals(that.film) : that.film != null) return false;
        if (acteur != null ? !acteur.equals(that.acteur) : that.acteur != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (film != null ? film.hashCode() : 0);
        result = 31 * result + (acteur != null ? acteur.hashCode() : 0);
        return result;
    }
}
