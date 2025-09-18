package com.movie.movieapi.dto.LoginDto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String username;

    private String password;
}
