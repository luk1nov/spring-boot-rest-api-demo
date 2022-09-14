package com.epam.esm.mapper;

import com.epam.esm.dto.UserDto;
import com.epam.esm.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends BaseMapper<UserDto, User>{
}
