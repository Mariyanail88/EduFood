package kg.attractor.edufood.mapper;



import kg.attractor.edufood.dto.UserDto;
import kg.attractor.edufood.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //  @Mapping(source = "parcelType", target = "type")
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    // Method to update an existing User entity from a UserDto
    void updateUserFromDto(UserDto userDto, @MappingTarget User user);
}
