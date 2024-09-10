package kg.attractor.edufood.mapper;

import kg.attractor.edufood.dto.RestaurantDto;
import kg.attractor.edufood.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
//, uses = MenuItemMapper.class
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(source = "menuItems", target = "menuItems")
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(source = "menuItems", target = "menuItems")
    Restaurant toRestaurant(RestaurantDto restaurantDto);
}
