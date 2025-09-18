package com.movie.movieapi.mapper;

import com.movie.movieapi.dto.UserDto;
import com.movie.movieapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto>{
}
