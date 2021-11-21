package iSergio.Reto04C3.repository;

import iSergio.Reto04C3.model.Mensaje;
import iSergio.Reto04C3.repository.crud.MensajeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeRepository {

    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> getAll(){return (List<Mensaje>) mensajeCrudRepository.findAll();}

    public Optional<Mensaje> getMensaje(int id){return mensajeCrudRepository.findById(id);}

    public Mensaje save(Mensaje msj){return mensajeCrudRepository.save(msj);}

    public void delete(Mensaje msj){
        mensajeCrudRepository.delete(msj);
    }
}
