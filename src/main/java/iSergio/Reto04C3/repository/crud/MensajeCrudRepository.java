package iSergio.Reto04C3.repository.crud;

import iSergio.Reto04C3.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeCrudRepository extends CrudRepository<Mensaje, Integer> {
}
