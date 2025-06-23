package com.empresa.ecommerce.service;

import com.empresa.ecommerce.dto.LoginDTO;
import com.empresa.ecommerce.dto.ResponseDTO;
import com.empresa.ecommerce.model.Usuario;

import java.util.HashMap;

public interface IAuthService {

    public HashMap<String, String> login(LoginDTO loginRequest) throws Exception;

    public Usuario guardar(Usuario usuario);

}
