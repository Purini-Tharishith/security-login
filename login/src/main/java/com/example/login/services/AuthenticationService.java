package com.example.login.services;

import com.example.login.dto.JwtAuthenticationResponse;
import com.example.login.dto.RefreshTokenRequest;
import com.example.login.dto.SignInRequest;
import com.example.login.dto.SignUpRequest;
import com.example.login.entities.User;

public interface AuthenticationService  {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
