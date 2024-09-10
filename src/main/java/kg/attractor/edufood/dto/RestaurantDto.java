package kg.attractor.edufood.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantDto {
    Long id;
    String name;
    String address;
    String phoneNumber;
    String email;
    String poster;
    List<MenuItemDto> menuItems;
}
