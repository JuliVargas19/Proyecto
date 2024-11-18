package com.example.biblioteca.Repository;

import com.example.biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
