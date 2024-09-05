package ci.digitalacademy.gestcantineada.Controller;

import ci.digitalacademy.gestcantineada.service.MenuService;
import ci.digitalacademy.gestcantineada.service.PlatService;
import ci.digitalacademy.gestcantineada.service.dtos.MenuDto;
import ci.digitalacademy.gestcantineada.service.dtos.PlatDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final PlatService platService;

    @GetMapping
    public String showMenuPage(Model model){
        model.addAttribute("menus", menuService.getAll());
        return "menu/menus";
    }

    @GetMapping("/add")
    public String showAddMenuPage( Model model){
        List<PlatDto> allPlats = new ArrayList<>(platService.getAll());
        List<MenuDto> allMenus = menuService.getAll();

        List<PlatDto> platsModifiable = new ArrayList<>(allPlats);
        for (PlatDto platDto : allPlats) {
            for (MenuDto menuDto : allMenus) {
                if (menuDto.getPlat().getId() == platDto.getId()) {
                    platsModifiable.remove(platDto);
                    break;
                }
            }
        }

        model.addAttribute("menu", new MenuDto());
        model.addAttribute("plats", platsModifiable);
        return "menu/forms";
    }


    @PostMapping
    public String saveMenu(MenuDto menuDto){
        menuDto.setCreation_date(Date.from(Instant.now()));
        menuService.save(menuDto);
        return "redirect:/menus";
    }

    @PostMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id){
        menuService.delete(id);
        return "redirect:/menus";
    }

    @GetMapping("/{id}")
    public String showUpdateMenuForm(Model model, @PathVariable Long id){
        Optional<MenuDto> menuDto = menuService.findOne(id);
        if(menuDto.isPresent()){
            model.addAttribute("menu", menuDto.get());
            return "menu/forms";
        }else {
            return "redirect:/menus";
        }
    }
}
