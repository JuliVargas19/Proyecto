package com.example.biblioteca.Service;

import com.example.biblioteca.InterfaceService.ILibroService;
import com.example.biblioteca.Model.Libro;
import com.example.biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService   {
    @Autowired
    private LibroRepository repository;

    @Override
    public List<Libro> listar() {
        return repository.findAll();
    }

    @Override
    public Libro obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void guardar(Libro libro) {
        repository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
