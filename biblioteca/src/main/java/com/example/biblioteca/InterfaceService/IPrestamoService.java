package com.example.biblioteca.InterfaceService;

import com.example.biblioteca.Model.Prestamo;

import java.util.List;

public interface IPrestamoService {
    List<Prestamo> listar();

    Prestamo obtenerPorId(Long id);

    void guardar(Prestamo Prestamo);

    void eliminar(Long id);

}
