package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "films", schema = "b3", catalog = "")
public class FilmsEntity {
    private int codeFilm;
    private String titreFilm;
    private int anneeFilm;
    private Set<JoueEntity> joues = new HashSet<JoueEntity>(0);

    @Id
    @Column(name = "codeFilm")
    public int getCodeFilm() {
        return codeFilm;
    }

    public void setCodeFilm(int codeFilm) {
        this.codeFilm = codeFilm;
    }

    @Basic
    @Column(name = "titreFilm")
    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    @Basic
    @Column(name = "anneeFilm")
    public int getAnneeFilm() {
        return anneeFilm;
    }

    public void setAnneeFilm(int anneeFilm) {
        this.anneeFilm = anneeFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmsEntity that = (FilmsEntity) o;

        if (codeFilm != that.codeFilm) return false;
        if (anneeFilm != that.anneeFilm) return false;
        if (titreFilm != null ? !titreFilm.equals(that.titreFilm) : that.titreFilm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeFilm;
        result = 31 * result + (titreFilm != null ? titreFilm.hashCode() : 0);
        result = 31 * result + anneeFilm;
        return result;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.film", cascade=CascadeType.ALL)
    public Set<JoueEntity> getJoues() {
        return this.joues;
    }

    public void setJoues(Set<JoueEntity> joues) {
        this.joues = joues;
    }

}
