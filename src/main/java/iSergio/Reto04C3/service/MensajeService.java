package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Mensaje;
import iSergio.Reto04C3.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> getAll(){return mensajeRepository.getAll();}

    public Optional<Mensaje> getMensaje(int id){return mensajeRepository.getMensaje(id);}

    public Mensaje save(Mensaje msj){
        if(msj.getIdMessage()==null){
            return mensajeRepository.save(msj);
        }else {
            Optional<Mensaje> msjAux=mensajeRepository.getMensaje(msj.getIdMessage());
            if(msjAux.isEmpty()){
                return mensajeRepository.save(msj);
            }else{
                return msj;
            }
        }
    }

    public Mensaje update(Mensaje msj){
        if(msj.getIdMessage()!=null){
            Optional<Mensaje> msjAux=mensajeRepository.getMensaje(msj.getIdMessage());
            if(!msjAux.isEmpty()){
                if(msj.getMessageText()!=null){
                    msjAux.get().setMessageText(msj.getMessageText());
                }
                return mensajeRepository.save(msjAux.get());
            }
        }
        return msj;
    }

    public boolean deleteMensaje(int id){
        Optional<Mensaje> msjAux=getMensaje(id);
        if(!msjAux.isEmpty()){
            mensajeRepository.delete(msjAux.get());
            return true;
        }
        return false;
    }
}
