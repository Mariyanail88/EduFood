package kg.attractor.edufood.service.impl;

import kg.attractor.edufood.dto.UserDto;
import kg.attractor.edufood.entity.Authority;
import kg.attractor.edufood.entity.Role;
import kg.attractor.edufood.entity.User;
import kg.attractor.edufood.exception.UserNotFoundException;
import kg.attractor.edufood.mapper.UserMapper;
import kg.attractor.edufood.repository.RoleRepository;
import kg.attractor.edufood.repository.UserRepository;
import kg.attractor.edufood.service.UserService;
import kg.attractor.edufood.util.ConsoleColors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final PasswordEncoder encoder;
    @Value("${app.user_not_found_with_id}")
    private String userByIdNotFound;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public List<UserDto> getUsersByName(String name) {
        return userRepository.findByName(name)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }


    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> {
                    log.error("Can't find user with email: {}", email);
                    return new UserNotFoundException("Can't find user with email: " + email);
                }
        );
        log.info(ConsoleColors.GREEN_BACKGROUND + "User found with email: {}" + ConsoleColors.RESET, email);
        log.info(ConsoleColors.ANSI_CYAN_BACKGROUND + "Roles: {}" + ConsoleColors.RESET, user.getRoles().stream().map(Role::getRoleName).collect(Collectors.joining(", ")));
        log.info(ConsoleColors.YELLOW_BACKGROUND + "Authorities: {}" + ConsoleColors.RESET, user.getRoles().stream()
                .flatMap(role -> role.getAuthorities().stream())
                .map(Authority::getAuthorityName)
                .collect(Collectors.joining(", ")));
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> {
                    log.error(userByIdNotFound, id);
                    return new NoSuchElementException(userByIdNotFound + id);
                }
        );

        log.info(
                ConsoleColors.GREEN_BACKGROUND + "User found with ID: {}" + ConsoleColors.RESET, id
        );
        return userMapper.toUserDto(user);
    }

    @Override
    @Transactional
    public void addUser(UserDto userDto) {
        userDto.setEnabled(true);
        String encodedPassword = encoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);

        // Log the encoded password
        log.info("Encoded password for user {}: {}", userDto.getEmail(), encodedPassword);

        User user = userMapper.toUser(userDto);

        // Initialize roles collection if null
        user.setRoles(initializeCollectionIfNull(user.getRoles()));

        // Assign the AUTHORIZED_USER role to the new user
        Role authorizedUserRole = roleRepository.findByRoleName("AUTHORIZED_USER").orElseThrow(
                () -> new NoSuchElementException("Role AUTHORIZED_USER not found")
        );

        user.getRoles().add(authorizedUserRole);
        userRepository.save(user);

        log.info(
                ConsoleColors.ANSI_BLUE +
                        "User saved to DB with email {} and role {}" +
                        ConsoleColors.RESET,
                userDto.getEmail(),
                authorizedUserRole.getRoleName()
        );

    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(
                () -> {
                    log.error(userByIdNotFound, userDto.getId());
                    return new NoSuchElementException(userByIdNotFound + userDto.getId());
                }
        );
        userMapper.updateUserFromDto(userDto, user);
        userRepository.save(user);
        log.info("User updated with ID: {}", userDto.getId());
    }

    @Override
    public boolean deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> {
                    log.error(userByIdNotFound, id);
                    return new NoSuchElementException(userByIdNotFound + id);
                });

        userRepository.delete(user);
        log.info("User deleted with ID: {}", id);
        return true;
    }

    private <T> Collection<T> initializeCollectionIfNull(Collection<T> collection) {
        return collection == null ? new HashSet<>() : collection;
    }

}
