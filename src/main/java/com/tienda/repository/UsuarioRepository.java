package com.tienda.repository;

import com.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByActivo(Boolean activo);
    List<Usuario> findByRolNombre(String rolNombre);
    
    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE %:nombre% OR u.apellido LIKE %:nombre%")
    List<Usuario> buscarPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.id = :id")
    Optional<Usuario> findByIdWithRol(@Param("id") Long id);
}