package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.Usuario;
import com.empresa.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public boolean existeUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existeEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void eliminarPorId(Long id){
        usuarioRepository.deleteById(id);
    }

}
