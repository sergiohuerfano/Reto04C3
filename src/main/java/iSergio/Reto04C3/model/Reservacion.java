package iSergio.Reto04C3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reservations")
public class Reservacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";


    @ManyToOne
    @JoinColumn(name="idCinema")
    @JsonIgnoreProperties({"reservations","messages,cinema"})
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name="client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy="reservation")
    @JoinColumn(name="idScore")
    @JsonIgnoreProperties("reservation")
    public Calificacion score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Calificacion getScore() {
        return score;
    }

    public void setScore(Calificacion score) {
        this.score = score;
    }
}
