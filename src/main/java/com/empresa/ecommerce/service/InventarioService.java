package com.empresa.ecommerce.service;

import com.empresa.ecommerce.model.Inventario;
import com.empresa.ecommerce.model.Producto;

import java.util.List;
import java.util.Optional;

public interface InventarioService {

    public List<Inventario> obtenerTodos();

    public Optional<Inventario> obtenerPorId(Long id);

    public Optional<Inventario> obtenerPorProducto(Producto producto);

    public boolean existePorProducto(Producto producto);

    public Inventario guardar(Inventario inventario);

    public void eliminarPorId(Long id);

}
