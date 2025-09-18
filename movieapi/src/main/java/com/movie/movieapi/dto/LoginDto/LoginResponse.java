package com.movie.movieapi.dto.LoginDto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String token;

    private String username;

    private List<String> roles;
}
