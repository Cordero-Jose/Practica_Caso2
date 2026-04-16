package com.tienda.service;

import com.tienda.model.Rol;
import com.tienda.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }
    
    public Optional<Rol> obtenerPorId(Long id) {
        return rolRepository.findById(id);
    }
    
    public Rol crear(Rol rol) {
        return rolRepository.save(rol);
    }
}