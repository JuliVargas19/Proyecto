package com.example.biblioteca.Controller;


import com.example.biblioteca.InterfaceService.ICategoriaService;
import com.example.biblioteca.InterfaceService.ILibroService;
import com.example.biblioteca.Model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.listar());
        return "libros";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearLibro(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("categorias", categoriaService.listar());
        return "libro_form";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libro") Libro libro) {
        libroService.guardar(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarLibro(@PathVariable("id") Long id, Model model) {
        Libro libro = libroService.obtenerPorId(id);
        if (libro != null) {
            model.addAttribute("libro", libro);
            model.addAttribute("categorias", categoriaService.listar());
            return "libro_form";
        }
        return "redirect:/libros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
        libroService.eliminar(id);
        return "redirect:/libros";
    }
}