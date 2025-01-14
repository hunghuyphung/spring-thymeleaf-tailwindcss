package vn.java.springthymeleaftailwindcss.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        var lastException = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");

        if (lastException instanceof AuthenticationException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "login";
    }
}
