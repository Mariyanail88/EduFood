package kg.attractor.edufood.controller.mvc;


import kg.attractor.edufood.dto.RestaurantDto;
import kg.attractor.edufood.service.RestaurantService;
import kg.attractor.edufood.service.UserService;
import kg.attractor.edufood.util.ConsoleColors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
    private final UserService userService;
    private final RestaurantService restaurantService;

    @GetMapping("/")
    public String welcome(Model model,
                          @PageableDefault(size = 5) Pageable pageable,
                          Authentication authentication) {
        restaurantMenuItemsLogging();

        Page<RestaurantDto> restaurants = restaurantService.getAllRestaurants(pageable);
        int currentPage = pageable.getPageNumber();
        int totalPages = restaurants.getTotalPages();
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
//        if (authentication != null && authentication.isAuthenticated()) {
//            UserDto userDto = userService.getUserByEmail(authentication.getName());
//            log.info(userDto.getRoles().toString());
//        }
        return "index";
    }

    private void restaurantMenuItemsLogging() {
        RestaurantDto restaurant = restaurantService.getRestaurantById(2L);
        restaurant.getMenuItems().forEach(item -> log.info(
                ConsoleColors.GREEN + "id:{}, restaurant id:{}, name:{}, description:{}, price:{}" + ConsoleColors.ANSI_RESET,
                item.getId(),
                item.getRestaurantId(),
                item.getName(),
                item.getDescription(),
                item.getPrice()
        ));
    }
}
