package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> obtenerTodos();

    public Optional<Usuario> obtenerPorId(Long id);

    public Optional<Usuario> obtenerPorUsername(String username);

    public boolean existeUsername(String username);

    public boolean existeEmail(String email);

    public void eliminarPorId(Long id);

}
