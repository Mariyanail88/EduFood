package kg.attractor.edufood.mapper;

import kg.attractor.edufood.dto.RestaurantDto;
import kg.attractor.edufood.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = MenuItemMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    @Mapping(source = "menuItems", target = "menuItems")
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(source = "menuItems", target = "menuItems")
    Restaurant toRestaurant(RestaurantDto restaurantDto);
}
