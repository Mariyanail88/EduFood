package kg.attractor.edufood.mapper;

import kg.attractor.edufood.dto.MenuItemDto;
import kg.attractor.edufood.entity.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuItemMapper {

    @Mapping(source = "restaurant.id", target = "restaurantId")
    MenuItemDto toMenuItemDto(MenuItem menuItem);

    @Mapping(target = "restaurant.id", source = "restaurantId")
    @Mapping(target = "restaurant", ignore = true)
    MenuItem toMenuItem(MenuItemDto menuItemDto);
}