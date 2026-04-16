package com.tienda.service;

import com.tienda.model.Usuario;
import com.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findByIdWithRol(id);
    }
    
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public Usuario actualizar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.buscarPorNombre(nombre);
    }
}