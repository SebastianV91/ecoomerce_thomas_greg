package com.empresa.ecommerce.repository;

import com.empresa.ecommerce.model.Orden;
import com.empresa.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    List<Orden> findByUsuario(Usuario usuario);

}
