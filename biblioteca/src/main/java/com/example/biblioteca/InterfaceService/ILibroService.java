package com.example.biblioteca.InterfaceService;

import com.example.biblioteca.Model.Libro;

import java.util.List;

public interface ILibroService {

        List<Libro> listar();
        Libro obtenerPorId(Long id);
        void guardar(Libro libro);
        void eliminar(Long id);

    }

