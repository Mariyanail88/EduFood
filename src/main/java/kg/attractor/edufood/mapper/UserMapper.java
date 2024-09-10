package kg.attractor.edufood.mapper;


import kg.attractor.edufood.dto.UserDto;
import kg.attractor.edufood.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    void updateUserFromDto(UserDto userDto, @MappingTarget User user);
}
