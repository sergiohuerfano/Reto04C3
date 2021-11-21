package iSergio.Reto04C3.repository;

import iSergio.Reto04C3.model.Calificacion;
import iSergio.Reto04C3.repository.crud.CalificacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CalificacionRepository {

    @Autowired
    private CalificacionCrudRepository calificacionCrudRepository;

    public List<Calificacion> getAll(){
        return (List<Calificacion>) calificacionCrudRepository.findAll();
    }

    public Optional<Calificacion> getCalifiacion (int id){
        return calificacionCrudRepository.findById(id);
    }

    public Calificacion save(Calificacion calificacion){
        return calificacionCrudRepository.save(calificacion);
    }
}
