package com.example.biblioteca.InterfaceService;

import com.example.biblioteca.Model.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> listar();
    Categoria obtenerPorId(Long id);
    void guardar(Categoria categoria);
    void eliminar(Long id);
}
