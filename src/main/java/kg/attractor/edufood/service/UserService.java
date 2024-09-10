package kg.attractor.edufood.service;


import kg.attractor.edufood.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    List<UserDto> getUsersByName(String name);

    UserDto getUserByEmail(String email);

    UserDto getUserById(Integer id);

    void addUser(UserDto userDto);

    boolean deleteUser(Integer id);

    void updateUser(UserDto userDto);

}

