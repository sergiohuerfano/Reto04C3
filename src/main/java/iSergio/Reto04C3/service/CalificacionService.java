package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Calificacion;
import iSergio.Reto04C3.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> getAll(){
        return calificacionRepository.getAll();
    }

    public Optional<Calificacion> getCalificacion(int id){
        return calificacionRepository.getCalifiacion(id);
    }

    public Calificacion save(Calificacion calificacion){
        if(calificacion.getIdScore()==null){
            return calificacionRepository.save(calificacion);
        }else {
            Optional<Calificacion> califiacionAux=calificacionRepository.getCalifiacion(calificacion.getIdScore());
            if(califiacionAux.isEmpty()){
                return calificacionRepository.save(calificacion);
            }else{
                return calificacion;
            }
        }
    }

    public Calificacion update(Calificacion score){
        if(score.getIdScore()!=null){
            Optional<Calificacion> scoreAux=calificacionRepository.getCalifiacion(score.getIdScore());
            if(!scoreAux.isEmpty()){
                if(score.getMsjScore()!=null){
                    scoreAux.get().setMsjScore(score.getMsjScore());
                }
                if(score.getScore()!=null){
                    scoreAux.get().setScore(score.getScore());
                }

                return calificacionRepository.save(scoreAux.get());
            }
        }
        return score;
    }
}
