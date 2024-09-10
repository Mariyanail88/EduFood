package kg.attractor.edufood.controller.mvc;


import jakarta.validation.Valid;
import kg.attractor.edufood.dto.UserDto;
import kg.attractor.edufood.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("login")
    public String login(Authentication authentication) {
        return "auth/login";
    }

    @GetMapping("register")
    public String register(Model model, CsrfToken csrfToken) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("_csrf", csrfToken);
        return "auth/register";
    }

    @PostMapping("register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            userService.addUser(userDto);
            return "redirect:/";
        }

        model.addAttribute("userDto", userDto);
        return "auth/register";
    }
}
