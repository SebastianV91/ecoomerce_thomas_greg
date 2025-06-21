package com.empresa.ecommerce.repository;

import com.empresa.ecommerce.model.Inventario;
import com.empresa.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findByProducto(Producto producto);

    boolean existsByProducto(Producto producto);

}
