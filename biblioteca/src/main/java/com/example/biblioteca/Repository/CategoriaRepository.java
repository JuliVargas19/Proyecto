package com.example.biblioteca.Repository;

import com.example.biblioteca.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
