package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.Orden;
import com.empresa.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface OrdenService {

    public List<Orden> obtenerTodas();

    public Optional<Orden> obtenerPorId(Long id);

    public List<Orden> obtenerPorUsuario(Usuario usuario);

    public Orden guardar(Orden orden);

    public void eliminarPorId(Long id);

    public boolean existePorId(Long id);

}
