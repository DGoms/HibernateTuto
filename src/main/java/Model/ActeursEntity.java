package Model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acteurs", schema = "b3")
public class ActeursEntity {
    private int codeActeur;
    private String prenomActeur;
    private String nomActeur;
    private int sexeActeur;
    private int anneeNaissanceActeur;
    private byte[] image;
    private Set<JoueEntity> joues = new HashSet<JoueEntity>(0);

    @Id
    @Column(name = "codeActeur")
    public int getCodeActeur() {
        return codeActeur;
    }

    public void setCodeActeur(int codeActeur) {
        this.codeActeur = codeActeur;
    }

    @Basic
    @Column(name = "prenomActeur")
    public String getPrenomActeur() {
        return prenomActeur;
    }

    public void setPrenomActeur(String prenomActeur) {
        this.prenomActeur = prenomActeur;
    }

    @Basic
    @Column(name = "nomActeur")
    public String getNomActeur() {
        return nomActeur;
    }

    public void setNomActeur(String nomActeur) {
        this.nomActeur = nomActeur;
    }

    @Basic
    @Column(name = "sexeActeur")
    public int getSexeActeur() {
        return sexeActeur;
    }

    public void setSexeActeur(int sexeActeur) {
        this.sexeActeur = sexeActeur;
    }

    @Basic
    @Column(name = "anneeNaissanceActeur")
    public int getAnneeNaissanceActeur() {
        return anneeNaissanceActeur;
    }

    public void setAnneeNaissanceActeur(int anneeNaissanceActeur) {
        this.anneeNaissanceActeur = anneeNaissanceActeur;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.acteur", cascade=CascadeType.ALL)
    public Set<JoueEntity> getJoues() {
        return this.joues;
    }

    public void setJoues(Set<JoueEntity> joues) {
        this.joues = joues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActeursEntity that = (ActeursEntity) o;

        if (codeActeur != that.codeActeur) return false;
        if (sexeActeur != that.sexeActeur) return false;
        if (anneeNaissanceActeur != that.anneeNaissanceActeur) return false;
        if (prenomActeur != null ? !prenomActeur.equals(that.prenomActeur) : that.prenomActeur != null) return false;
        if (nomActeur != null ? !nomActeur.equals(that.nomActeur) : that.nomActeur != null) return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeActeur;
        result = 31 * result + (prenomActeur != null ? prenomActeur.hashCode() : 0);
        result = 31 * result + (nomActeur != null ? nomActeur.hashCode() : 0);
        result = 31 * result + sexeActeur;
        result = 31 * result + anneeNaissanceActeur;
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
