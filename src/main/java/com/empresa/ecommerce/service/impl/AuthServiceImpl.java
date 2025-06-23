package com.empresa.ecommerce.service.impl;

import com.empresa.ecommerce.dto.LoginDTO;
import com.empresa.ecommerce.model.Usuario;
import com.empresa.ecommerce.repository.UsuarioRepository;
import com.empresa.ecommerce.service.IAuthService;
import com.empresa.ecommerce.service.IJWTUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IJWTUtilityService jwtUtilityService;

    @Override
    public HashMap<String, String> login(LoginDTO loginRequest) throws Exception {

        try{

            HashMap<String, String> jwt = new HashMap<>();
            Optional<Usuario> user = usuarioRepository.findByUsername(loginRequest.getUsername());

            if(user.isEmpty()){
                jwt.put("error", "Usuario no registrado!");
                return jwt;
            }

            if (verifyPassword(loginRequest.getPassword(), user.get().getPassword())){
                jwt.put("jwt", jwtUtilityService.generateJWT(user.get().getId()));
            }else{
                jwt.put("error", "Autenticacion fallida");
            }

            return jwt;

        } catch (IllegalArgumentException e){
            System.err.println("Error generating JWT: " + e.getMessage());
            throw new Exception("Error generating JWT", e);
        } catch(Exception e){
            System.err.println("Unknown error: " + e.toString());
            throw new Exception("Unknown error:", e);
        }
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        usuario.setPassword(encoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }

}
