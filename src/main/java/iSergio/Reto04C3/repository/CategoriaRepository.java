package iSergio.Reto04C3.repository;


import iSergio.Reto04C3.model.Categoria;
import iSergio.Reto04C3.repository.crud.CategoriaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return categoriaCrudRepository.findById(id);
    }

    public Categoria save(Categoria categoria){
        return categoriaCrudRepository.save(categoria);
    }

    public void delete(Categoria categoria){
        categoriaCrudRepository.delete(categoria);
    }
}
