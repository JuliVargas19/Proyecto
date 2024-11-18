package com.example.biblioteca.Repository;

import com.example.biblioteca.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
