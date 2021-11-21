package iSergio.Reto04C3.controller;

import iSergio.Reto04C3.model.Calificacion;
import iSergio.Reto04C3.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Score")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/all")
    public List<Calificacion> getCalificaciones(){
        return calificacionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Calificacion> getCalificacion(@PathVariable("id") int id){
        return calificacionService.getCalificacion(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion save(@RequestBody Calificacion calificacion){
        return calificacionService.save(calificacion);
    }
}
