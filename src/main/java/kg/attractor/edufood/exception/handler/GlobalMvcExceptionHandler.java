package kg.attractor.edufood.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.edufood.exception.ErrorResponseBody;
import kg.attractor.edufood.exception.ResourceNotFoundException;
import kg.attractor.edufood.exception.RestaurantNotFoundException;
import kg.attractor.edufood.service.ErrorService;
import kg.attractor.edufood.util.ConsoleColors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class GlobalMvcExceptionHandler {
    private final ErrorService errorService;

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ModelAndView handleException(HttpServletRequest request, RestaurantNotFoundException restaurantNotFoundException, Model model) {
        int statusCode = 404;
        logging(request.getRequestURL().toString(), restaurantNotFoundException.getMessage());

        return getModelAndView(restaurantNotFoundException, statusCode);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex, Model model) {
        logging(request.getRequestURL().toString(), ex.getMessage());
        int statusCode = 520;
        return getModelAndView(ex, statusCode);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex) {
        logging(request.getRequestURL().toString(), ex.getMessage());
        int statusCode = 404;
        return getModelAndView(ex, statusCode);
    }

    private ModelAndView getModelAndView(Exception ex, int statusCode) {
        ErrorResponseBody errorResponse = errorService.makeResponse(ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("statusCode", statusCode);
        modelAndView.addObject("errorMessage", errorResponse.getError());
        modelAndView.addObject("reasons", errorResponse.getReasons());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    private static void logging(String requestUrl, String exceptionMessage) {
        log.error(
                ConsoleColors.RED +
                        "Request: {} raised error(s) {}", requestUrl, exceptionMessage +
                        ConsoleColors.RESET
        );
    }
}
