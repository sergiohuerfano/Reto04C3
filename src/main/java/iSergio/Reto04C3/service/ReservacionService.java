package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Reservacion;
import iSergio.Reto04C3.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservacionService {

    @Autowired
    private ReservacionRepository reservacionRepository;

    public List<Reservacion> getAll(){return reservacionRepository.getAll();}

    public Optional<Reservacion> getReserva(int id){return reservacionRepository.getReserva(id);}

    public Reservacion save(Reservacion reserva){
        if(reserva.getIdReservation()==null){
            return reservacionRepository.save(reserva);
        }else {
            Optional<Reservacion> reservaAux=reservacionRepository.getReserva(reserva.getIdReservation());
            if(reservaAux.isEmpty()){
                return reservacionRepository.save(reserva);
            }else{
                return reserva;
            }
        }
    }

    public Reservacion update(Reservacion reserva){
        if(reserva.getIdReservation()!=null){
            Optional<Reservacion> reservaAux=reservacionRepository.getReserva(reserva.getIdReservation());
            if(!reservaAux.isEmpty()){
                if(reserva.getStartDate()!=null){
                    reservaAux.get().setStartDate(reserva.getStartDate());
                }
                if(reserva.getDevolutionDate()!=null){
                    reservaAux.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if(reserva.getStatus()!=null){
                    reservaAux.get().setStatus(reserva.getStatus());
                }
                return reservacionRepository.save(reservaAux.get());
            }
        }
        return reserva;
    }

    public boolean deleteReserva(int id){
        Optional<Reservacion> reserAux=getReserva(id);
        if(!reserAux.isEmpty()){
            reservacionRepository.delete(reserAux.get());
            return true;
        }
        return false;
    }
}
