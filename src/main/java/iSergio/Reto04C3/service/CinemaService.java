package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Cinema;
import iSergio.Reto04C3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema sala){
        if(sala.getId()==null){
            return cinemaRepository.save(sala);
        }else {
            Optional<Cinema> salaAux=cinemaRepository.getCinema(sala.getId());
            if(salaAux.isEmpty()){
                return cinemaRepository.save(sala);
            }else{
                return sala;
            }
        }
    }

    public Cinema update(Cinema cinema){
        if(cinema.getId()!=null){
            Optional<Cinema> cine=cinemaRepository.getCinema(cinema.getId());
            if(!cine.isEmpty()){
                if(cinema.getName()!=null){
                    cine.get().setName(cinema.getName());
                }
                if(cinema.getOwner()!=null){
                    cine.get().setOwner(cinema.getOwner());
                }
                if(cinema.getCapacity()!=null){
                    cine.get().setCapacity(cinema.getCapacity());
                }
                if(cinema.getDescription()!=null){
                    cine.get().setDescription(cinema.getDescription());
                }
                return cinemaRepository.save(cine.get());
            }
        }
        return cinema;
    }

    public boolean deleteCinema(int id){
        Optional<Cinema> cineAux=getCinema(id);
        if(!cineAux.isEmpty()){
            cinemaRepository.delete(cineAux.get());
            return true;
        }
        return false;
    }
}
