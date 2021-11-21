package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Cinema;
import iSergio.Reto04C3.model.Cliente;
import iSergio.Reto04C3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){return clienteRepository.getAll();}

    public Optional<Cliente> getCliente(int id){return clienteRepository.getCliente(id);}

    public Cliente save(Cliente cliente){
        if(cliente.getIdClient()==null){
            return clienteRepository.save(cliente);
        }else {
            Optional<Cliente> clienteAux=clienteRepository.getCliente(cliente.getIdClient());
            if(clienteAux.isEmpty()){
                return clienteRepository.save(cliente);
            }else{
                return cliente;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> clientAux=clienteRepository.getCliente(client.getIdClient());
            if(!clientAux.isEmpty()){
                if(client.getEmail()!=null){
                    clientAux.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    clientAux.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    clientAux.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    clientAux.get().setAge(client.getAge());
                }
                return clienteRepository.save(clientAux.get());
            }
        }
        return client;
    }

    public boolean deleteCliente(int id){
        Optional<Cliente> clienteAux=getCliente(id);
        if(!clienteAux.isEmpty()){
            clienteRepository.delete(clienteAux.get());
            return true;
        }
        return false;
    }

}
