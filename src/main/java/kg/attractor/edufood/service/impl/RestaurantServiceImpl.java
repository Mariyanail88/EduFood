package kg.attractor.edufood.service.impl;

import kg.attractor.edufood.dto.RestaurantDto;
import kg.attractor.edufood.entity.Restaurant;
import kg.attractor.edufood.exception.RestaurantNotFoundException;
import kg.attractor.edufood.mapper.CustomRestaurantMapper;
import kg.attractor.edufood.mapper.RestaurantMapper;
import kg.attractor.edufood.repository.RestaurantRepository;
import kg.attractor.edufood.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper = RestaurantMapper.INSTANCE;
    private final CustomRestaurantMapper customRestaurantMapper;

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(restaurantMapper::toRestaurantDto)
                .toList();
    }

    @Override
    public Page<RestaurantDto> getAllRestaurants(Pageable pageable) {
        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);
        List<RestaurantDto> restaurantDtos = restaurants.get()
                .map(restaurantMapper::toRestaurantDto)
                .toList();
        return new PageImpl<>(restaurantDtos, pageable, restaurants.getTotalElements());
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(RestaurantNotFoundException::new);
        // MapStruct не подхватывает restaurant_id, поэтом пришлось сделать кастомный мэппер
        return customRestaurantMapper.toRestaurantDto(restaurant);
    }

    @Override
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantMapper.toRestaurant(restaurantDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.toRestaurantDto(savedRestaurant);
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantMapper.toRestaurant(restaurantDto);
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.toRestaurantDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}