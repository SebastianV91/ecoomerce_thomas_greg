package com.empresa.ecommerce.service.impl;

import com.empresa.ecommerce.model.Producto;
import com.empresa.ecommerce.repository.ProductoRepository;
import com.empresa.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public void eliminarPorId(Long id){
        productoRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return productoRepository.existsById(id);
    }

}
