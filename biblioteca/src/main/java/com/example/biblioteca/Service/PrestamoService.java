package com.example.biblioteca.Service;

import com.example.biblioteca.InterfaceService.IPrestamoService;
import com.example.biblioteca.Model.Prestamo;
import com.example.biblioteca.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService implements IPrestamoService {
    @Autowired
    private PrestamoRepository repository;

    @Override
    public List<Prestamo> listar() {
        return repository.findAll();
    }

    @Override
    public Prestamo obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Prestamo prestamo) {
        repository.save(prestamo);
    }

         @Override
    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
