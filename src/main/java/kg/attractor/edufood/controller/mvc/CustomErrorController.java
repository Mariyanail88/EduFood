package kg.attractor.edufood.controller.mvc;


import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.edufood.exception.ErrorResponseBody;
import kg.attractor.edufood.service.ErrorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CustomErrorController implements ErrorController {
    private final ErrorService errorService;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        if (statusCode == null) {
            statusCode = 500; // Default to 500 if status code is not available
        }

        if (errorMessage == null) {
            errorMessage = "An unexpected error occurred";
        }

        log.error("Error with status code {} and message {}", statusCode, errorMessage);

        ErrorResponseBody errorResponse = errorService.makeResponse(new Exception(errorMessage));

        model.addAttribute("statusCode", statusCode);
        model.addAttribute("errorMessage", errorResponse.getError());
        model.addAttribute("reasons", errorResponse.getReasons());

        return "error";
    }

}