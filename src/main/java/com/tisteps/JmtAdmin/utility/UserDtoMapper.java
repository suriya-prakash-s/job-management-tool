package com.tisteps.JmtAdmin.utility;

import com.tisteps.JmtAdmin.DTO.UserDTO;
import com.tisteps.JmtAdmin.entity.User;

public class UserDtoMapper {
    public static UserDTO userDtoMapper(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getJobRole()
        );
    }
}
