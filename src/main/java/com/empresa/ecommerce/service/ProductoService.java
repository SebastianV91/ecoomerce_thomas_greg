package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public List<Producto> obtenerTodos();

    public Optional<Producto> obtenerPorId(Long id);

    public Producto guardar(Producto producto);

    public void eliminarPorId(Long id);

    public boolean existePorId(Long id);

}
