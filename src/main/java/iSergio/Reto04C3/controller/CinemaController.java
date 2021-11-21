package iSergio.Reto04C3.controller;

import iSergio.Reto04C3.model.Cinema;
import iSergio.Reto04C3.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<Cinema> getCinemas(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id") int id){
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema sala){
        return cinemaService.save(sala);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema update(@RequestBody Cinema sala) {return cinemaService.update(sala);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){ return cinemaService.deleteCinema(id);}
}
