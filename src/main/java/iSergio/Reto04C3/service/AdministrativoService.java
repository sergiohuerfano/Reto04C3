package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Administrativo;
import iSergio.Reto04C3.repository.AdministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    public List<Administrativo> getAll(){
        return administrativoRepository.getAll();
    }

    public Optional<Administrativo> getAdministrativo(int id){
        return administrativoRepository.getAdministrativo(id);
    }

    public Administrativo save(Administrativo administrativo){
        if(administrativo.getIdAdmin()==null){
            return administrativoRepository.save(administrativo);
        }else {
            Optional<Administrativo> adminAux=administrativoRepository.getAdministrativo(administrativo.getIdAdmin());
            if(adminAux.isEmpty()){
                return administrativoRepository.save(administrativo);
            }else{
                return administrativo;
            }
        }
    }

    public Administrativo update(Administrativo admin){
        if(admin.getIdAdmin()!=null){
            Optional<Administrativo> adminAux=administrativoRepository.getAdministrativo(admin.getIdAdmin());
            if(!adminAux.isEmpty()){
                if(admin.getEmail()!=null){
                    adminAux.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    adminAux.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    adminAux.get().setName(admin.getName());
                }
                return administrativoRepository.save(adminAux.get());
            }
        }
        return admin;
    }

    public boolean deleteAdmin(int id){
        Optional<Administrativo> adminAux=getAdministrativo(id);
        if(!adminAux.isEmpty()){
            administrativoRepository.delete(adminAux.get());
            return true;
        }
        return false;
    }
}
