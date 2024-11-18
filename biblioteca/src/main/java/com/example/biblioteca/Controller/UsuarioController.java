package com.example.biblioteca.Controller;


import com.example.biblioteca.InterfaceService.IUsuarioService;
import com.example.biblioteca.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    @RequestMapping("/usuarios")
    public class UsuarioController {

        @Autowired
        private IUsuarioService usuarioService;

        @GetMapping
        public String listarUsuarios(Model model) {
            model.addAttribute("usuarios", usuarioService.listar());
            return "usuarios";
        }

        @GetMapping("/nuevo")
        public String mostrarFormularioUsuario(Model model) {
            model.addAttribute("usuario", new Usuario());
            return "usuario_form";
        }

        @PostMapping
        public String guardarUsuario(@ModelAttribute Usuario usuario) {
            usuarioService.guardar(usuario);
            return "redirect:/usuarios";
        }

        @GetMapping("/editar/{id}")
        public String editarUsuario(@PathVariable Long id, Model model) {
            Usuario usuario = usuarioService.obtenerPorId(id);
            model.addAttribute("usuario", usuario);
            return "usuario_form";
        }

        @GetMapping("/eliminar/{id}")
        public String eliminarUsuario(@PathVariable Long id) {
            usuarioService.eliminar(id);
            return "redirect:/usuarios";
    }
}
