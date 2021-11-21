package iSergio.Reto04C3.repository;

import iSergio.Reto04C3.model.Reservacion;
import iSergio.Reto04C3.repository.crud.ReservacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservacionRepository {

    @Autowired
    private ReservacionCrudRepository reservacionCrudRepository;

    public List<Reservacion> getAll(){return (List<Reservacion>) reservacionCrudRepository.findAll();}

    public Optional<Reservacion> getReserva(int id){return reservacionCrudRepository.findById(id);}

    public Reservacion save(Reservacion msj){return reservacionCrudRepository.save(msj);}

    public void delete(Reservacion reservacion){
        reservacionCrudRepository.delete(reservacion);
    }
}
