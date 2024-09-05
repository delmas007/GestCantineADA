package ci.digitalacademy.gestcantineada.Controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class IndexController {

    @GetMapping
    public String showHomePage(HttpServletRequest request, Model model){

        String currentUrl = request.getRequestURI();
        model.addAttribute("currentUrl", currentUrl);
        return "home/index";
    }
}
