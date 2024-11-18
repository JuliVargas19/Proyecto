package com.example.biblioteca.Controller;


import com.example.biblioteca.InterfaceService.ILibroService;
import com.example.biblioteca.InterfaceService.IPrestamoService;
import com.example.biblioteca.InterfaceService.IUsuarioService;
import com.example.biblioteca.Model.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private IPrestamoService prestamoService;

    @Autowired
    private ILibroService libroService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public String listarPrestamos(Model model) {
        model.addAttribute("prestamos", prestamoService.listar());
        return "prestamos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearPrestamo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("libros", libroService.listar());
        model.addAttribute("usuarios", usuarioService.listar());
        return "prestamo_form";
    }

    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute("prestamo") Prestamo prestamo) {
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamoService.guardar(prestamo);
        return "redirect:/prestamos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPrestamo(@PathVariable("id") Long id, Model model) {
        Prestamo prestamo = prestamoService.obtenerPorId(id);
        if (prestamo == null) {
            return "redirect:/prestamos";
        }
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("libros", libroService.listar());
        model.addAttribute("usuarios", usuarioService.listar());
        return "prestamo_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPrestamo(@PathVariable("id") Long id) {
        prestamoService.eliminar(id);
        return "redirect:/prestamos";
    }
}