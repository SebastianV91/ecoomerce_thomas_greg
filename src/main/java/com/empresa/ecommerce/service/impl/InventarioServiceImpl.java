package com.empresa.ecommerce.service.impl;

import com.empresa.ecommerce.model.Inventario;
import com.empresa.ecommerce.model.Producto;
import com.empresa.ecommerce.repository.InventarioRepository;
import com.empresa.ecommerce.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;

    @Autowired
    public InventarioServiceImpl(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> obtenerTodos(){
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerPorId(Long id){
        return inventarioRepository.findById(id);
    }

    public Optional<Inventario> obtenerPorProducto(Producto producto){
        return inventarioRepository.findByProducto(producto);
    }

    public boolean existePorProducto(Producto producto){
        return inventarioRepository.existsByProducto(producto);
    }

    public Inventario guardar(Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    public void eliminarPorId(Long id){
        inventarioRepository.deleteById(id);
    }

}
