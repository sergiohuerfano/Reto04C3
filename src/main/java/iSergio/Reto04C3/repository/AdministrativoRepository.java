package iSergio.Reto04C3.repository;

import iSergio.Reto04C3.model.Administrativo;
import iSergio.Reto04C3.repository.crud.AdministrativoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministrativoRepository {

    @Autowired
    private AdministrativoCrudRepository administrativoCrudRepository;

    public List<Administrativo> getAll(){
        return (List<Administrativo>) administrativoCrudRepository.findAll();
    }

    public Optional<Administrativo> getAdministrativo(int id){
        return administrativoCrudRepository.findById(id);
    }

    public Administrativo save(Administrativo administrativo){
        return administrativoCrudRepository.save(administrativo);
    }

    public void delete(Administrativo administrativo){
        administrativoCrudRepository.delete(administrativo);
    }
}
