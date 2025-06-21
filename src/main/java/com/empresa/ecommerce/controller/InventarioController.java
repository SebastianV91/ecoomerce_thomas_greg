package com.empresa.ecommerce.controller;

import com.empresa.ecommerce.model.Inventario;
import com.empresa.ecommerce.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = "*")
public class InventarioController {

    private final InventarioService inventarioService;

    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> listarInventario(){
        return ResponseEntity.ok(inventarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        return inventarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearInventario(@Valid @RequestBody Inventario inventario){

        if(inventario.getProducto() == null){
            return ResponseEntity.badRequest().body("Debe asociar un producto al inventario");
        }

        if(inventarioService.existePorProducto(inventario.getProducto())){
            return ResponseEntity.badRequest().body("El inventario para este producto ya existe");
        }

        Inventario nuevoInventario = inventarioService.guardar(inventario);

        return ResponseEntity.ok(nuevoInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarInventario(@PathVariable Long id, @Valid @RequestBody Inventario inventarioActualizado){

        if(!inventarioService.obtenerPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        inventarioActualizado.setId(id);
        Inventario actualizado = inventarioService.guardar(inventarioActualizado);
        return ResponseEntity.ok(actualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInventario(@PathVariable Long id){

        if(!inventarioService.obtenerPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        inventarioService.eliminarPorId(id);
        return ResponseEntity.ok("Inventario eliminado");

    }

}
