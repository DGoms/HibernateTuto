package Model;

import javax.persistence.*;

@Entity
@Table(name = "joue", schema = "b3")
//@IdClass(JoueEntityPK.class)
@AssociationOverrides({
        @AssociationOverride(name = "pk.film",
                joinColumns = @JoinColumn(name = "codeF")),
        @AssociationOverride(name = "pk.acteur",
                joinColumns = @JoinColumn(name = "codeA")) })
public class JoueEntity {
    private JoueEntityPK pk = new JoueEntityPK();
    private String casting;

    @EmbeddedId
    public JoueEntityPK getPk() {
        return pk;
    }

    public void setPk(JoueEntityPK pk) {
        this.pk = pk;
    }

    @Transient
    public FilmsEntity getFilm() {
        return getPk().getFilm();
    }

    public void setFilm(FilmsEntity film) {
        getPk().setFilm(film);
    }

    @Transient
    public ActeursEntity getActeur() {
        return getPk().getActeur();
    }

    public void setActeur(ActeursEntity acteur) {
        getPk().setActeur(acteur);
    }

    @Basic
    @Column(name = "casting")
    public String getCasting() {
        return casting;
    }

    public void setCasting(String casting) {
        this.casting = casting;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JoueEntity that = (JoueEntity) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null)
            return false;
        if(casting != null ? !casting.equals(that.casting) : that.casting != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
