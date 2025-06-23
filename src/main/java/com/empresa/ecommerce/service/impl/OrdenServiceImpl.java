package com.empresa.ecommerce.service.impl;

import com.empresa.ecommerce.model.Orden;
import com.empresa.ecommerce.model.Usuario;
import com.empresa.ecommerce.repository.OrdenRepository;
import com.empresa.ecommerce.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> obtenerTodas(){
        return ordenRepository.findAll();
    }

    public Optional<Orden> obtenerPorId(Long id){
        return ordenRepository.findById(id);
    }

    public List<Orden> obtenerPorUsuario(Usuario usuario){
        return ordenRepository.findByUsuario(usuario);
    }

    public Orden guardar(Orden orden){
        return ordenRepository.save(orden);
    }

    public void eliminarPorId(Long id){
        ordenRepository.deleteById(id);
    }

    public boolean existePorId(Long id){
        return ordenRepository.existsById(id);
    }

}
