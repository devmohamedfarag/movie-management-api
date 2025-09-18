package com.movie.movieapi.Security;

import com.movie.movieapi.dto.LoginDto.LoginRequest;
import com.movie.movieapi.dto.LoginDto.LoginResponse;
import com.movie.movieapi.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public LoginResponse login(LoginRequest request) {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtService.generateToken(userDetails);
            List<String> roles = userDetails.getAuthorities()
                    .stream().map(GrantedAuthority::getAuthority).toList();

            return new LoginResponse(jwt, userDetails.getUsername(), roles);



    }
}