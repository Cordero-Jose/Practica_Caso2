package com.tienda.controller;

import com.tienda.model.Usuario;
import com.tienda.service.UsuarioService;
import com.tienda.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        return "usuarios/listar";
    }
    
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.obtenerTodos());
        return "usuarios/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.crear(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/{id}/editar")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obtenerPorId(id).orElseThrow();
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolService.obtenerTodos());
        return "usuarios/formulario";
    }
    
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuario.setId(id);
        usuarioService.actualizar(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}