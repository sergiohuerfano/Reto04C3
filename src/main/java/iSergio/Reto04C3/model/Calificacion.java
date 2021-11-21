package iSergio.Reto04C3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="calificion")
public class Calificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private String msjScore;
    private Integer score;

    @OneToOne
    @JoinColumn(name="idReservation")
    @JsonIgnoreProperties("score")
    private Reservacion reservation;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public String getMsjScore() {
        return msjScore;
    }

    public void setMsjScore(String msjScore) {
        this.msjScore = msjScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;

    }

    public Reservacion getReservation() {
        return reservation;
    }

    public void setReservation(Reservacion reservation) {
        this.reservation = reservation;
    }
}
