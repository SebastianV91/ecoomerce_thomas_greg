package com.empresa.ecommerce.controller;

import com.empresa.ecommerce.dto.LoginDTO;
import com.empresa.ecommerce.model.Usuario;
import com.empresa.ecommerce.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    private ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario){

        Usuario nuevo = authService.guardar(usuario);
        return ResponseEntity.ok(nuevo);

    }

    @PostMapping("/login")
    private ResponseEntity<HashMap<String, String>> login(@RequestBody LoginDTO loginRequest) throws Exception {

        HashMap<String, String> login = authService.login(loginRequest);

        if(login.containsKey("jwt")){
            return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.UNAUTHORIZED);
        }

    }

}
