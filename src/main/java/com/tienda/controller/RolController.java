package com.tienda.controller;

import com.tienda.model.Rol;
import com.tienda.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("roles", rolService.obtenerTodos());
        return "roles/listar";
    }
    
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/formulario";
    }
    
    @PostMapping
    public String guardar(@ModelAttribute Rol rol) {
        rolService.crear(rol);
        return "redirect:/roles";
    }
}