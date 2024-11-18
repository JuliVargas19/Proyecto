package com.example.biblioteca.Service;

import com.example.biblioteca.InterfaceService.IUsuarioService;
import com.example.biblioteca.Model.Usuario;
import com.example.biblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
