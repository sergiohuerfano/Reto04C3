package iSergio.Reto04C3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*
@author Sergio Huerfano
Cinema
 */
@Entity
@Table(name="cinemas")
public class Cinema implements Serializable {

    /**
    Se deben suministrar los datos del sistema
    @param id generado automaticamente
     @param name nombre de la sala
     @param owner propietario del cine
     @param capacity capacidad de personas en la sala
     @param description informacion complementaria
    **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;

    /*
    @author Sergio Huerfano
    */
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("cinemas")
    private Categoria category;

    /*
    @author Sergio Huerfano
    Relacion
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema","client"})
    private List<Mensaje> messages;

    /*
    @author Sergio Huerfano
    Relacion
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties("cinemas")
    private List<Reservacion> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservacion) {
        this.reservations = reservacion;
    }
}
