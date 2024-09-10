package kg.attractor.edufood.mapper;

import kg.attractor.edufood.dto.MenuItemDto;
import kg.attractor.edufood.dto.RestaurantDto;
import kg.attractor.edufood.entity.MenuItem;
import kg.attractor.edufood.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomRestaurantMapper  {
    private final MenuItemMapper menuItemMapper;


    public RestaurantDto toRestaurantDto(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        List<MenuItemDto> menuItemDtos = restaurant.getMenuItems().stream()
                .map(menuItemMapper::toMenuItemDto)
                .collect(Collectors.toList());

        return RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .phoneNumber(restaurant.getPhoneNumber())
                .email(restaurant.getEmail())
                .poster(restaurant.getPoster())
                .menuItems(menuItemDtos)
                .build();
    }


    public Restaurant toRestaurant(RestaurantDto restaurantDto) {
        if (restaurantDto == null) {
            return null;
        }

        List<MenuItem> menuItems = restaurantDto.getMenuItems().stream()
                .map(menuItemMapper::toMenuItem)
                .collect(Collectors.toList());

        return Restaurant.builder()
                .id(restaurantDto.getId())
                .name(restaurantDto.getName())
                .address(restaurantDto.getAddress())
                .phoneNumber(restaurantDto.getPhoneNumber())
                .email(restaurantDto.getEmail())
                .poster(restaurantDto.getPoster())
                .menuItems(menuItems)
                .build();
    }
}
