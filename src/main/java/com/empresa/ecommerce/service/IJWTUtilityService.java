package com.empresa.ecommerce.service;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

public interface IJWTUtilityService {

    public String generateJWT(Long userId) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, JOSEException;

    public JWTClaimsSet parseJWT(String jwt) throws JOSEException, IOException, ParseException, NoSuchAlgorithmException, InvalidKeySpecException;

}
