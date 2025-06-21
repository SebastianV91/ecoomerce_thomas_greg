package com.empresa.ecommerce.controller;

import com.empresa.ecommerce.model.Orden;
import com.empresa.ecommerce.service.OrdenService;
import com.empresa.ecommerce.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {

    private final OrdenService ordenService;
    private final UsuarioService usuarioService;

    @Autowired
    public OrdenController(OrdenService ordenService, UsuarioService usuarioService) {
        this.ordenService = ordenService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Orden>> listarTodas() {
        return ResponseEntity.ok(ordenService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        return ordenService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return usuarioService.obtenerPorId(usuarioId)
                .map(usuario -> ResponseEntity.ok(ordenService.obtenerPorUsuario(usuario)))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<?> crearOrden(@Valid @RequestBody Orden orden) {

        if (orden.getUsuario() == null) {
            return ResponseEntity.badRequest().body("Debe asociar un usuario a la orden");
        }

        Orden nueva = ordenService.guardar(orden);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarOrden(@PathVariable Long id, @RequestBody Orden ordenActualizada){

        if(!ordenService.existePorId(id)){
            return ResponseEntity.notFound().build();
        }

        ordenActualizada.setId(id);
        Orden actualizada = ordenService.guardar(ordenActualizada);
        return ResponseEntity.ok(actualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorOrden(@PathVariable Long id){

        if(!ordenService.existePorId(id)){
            return ResponseEntity.notFound().build();
        }

        ordenService.eliminarPorId(id);
        return ResponseEntity.ok("Orden eliminada");

    }

}
