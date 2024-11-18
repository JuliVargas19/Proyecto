package com.example.biblioteca.InterfaceService;

import com.example.biblioteca.Model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listar();
    Usuario obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
}
