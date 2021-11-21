package iSergio.Reto04C3.service;

import iSergio.Reto04C3.model.Categoria;
import iSergio.Reto04C3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return categoriaRepository.getAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }

    public Categoria save(Categoria categoria){
        if(categoria.getId()==null){
            return categoriaRepository.save(categoria);
        }else {
            Optional<Categoria> categoriaAux=categoriaRepository.getCategoria(categoria.getId());
            if(categoriaAux.isEmpty()){
                return categoriaRepository.save(categoria);
            }else{
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria> catg=categoriaRepository.getCategoria(categoria.getId());
            if(!catg.isEmpty()){
                if(categoria.getName()!=null){
                    catg.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null) {
                    catg.get().setDescription(categoria.getDescription());
                }
                return categoriaRepository.save(catg.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategoria(int id){
        Optional<Categoria> catAux=getCategoria(id);
        if(!catAux.isEmpty()){
            categoriaRepository.delete(catAux.get());
            return true;
        }
        return false;
    }
}
