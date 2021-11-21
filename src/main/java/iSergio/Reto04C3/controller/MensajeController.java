package iSergio.Reto04C3.controller;

import iSergio.Reto04C3.model.Mensaje;
import iSergio.Reto04C3.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Message")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/all")
    public List<Mensaje> getMensajes(){
        return mensajeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensaje(@PathVariable("id") int id){
        return mensajeService.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje msj){
        return mensajeService.save(msj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje msj) {return mensajeService.update(msj);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){ return mensajeService.deleteMensaje(id);}
}
