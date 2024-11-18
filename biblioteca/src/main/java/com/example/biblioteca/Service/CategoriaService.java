package com.example.biblioteca.Service;

import com.example.biblioteca.InterfaceService.ICategoriaService;
import com.example.biblioteca.Model.Categoria;
import com.example.biblioteca.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Categoria categoria) {
        repository.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
         repository.deleteById(id);
    }

}
