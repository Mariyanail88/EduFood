package kg.attractor.edufood.service;

import kg.attractor.edufood.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    Page<RestaurantDto> getAllRestaurants(Pageable pageable);
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto getRestaurantById(Long id);
    RestaurantDto addRestaurant(RestaurantDto restaurantDto);
    RestaurantDto updateRestaurant(RestaurantDto restaurantDto);
    void deleteRestaurant(Long id);
}
