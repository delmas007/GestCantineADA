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
@RequestMapping("/plats")
@RequiredArgsConstructor
public class PlatController {
    private final MenuService menuService;
    private final PlatService platService;

    @GetMapping
    public String showPlatPage( Model model){
        model.addAttribute("plats", platService.getAll());
        return "plat/plats";
    }

    @GetMapping("/add")
    public String showAddPlatPage( Model model){
        model.addAttribute("plat", new PlatDto());
        return "plat/forms";
    }

    @PostMapping
    public String savePlat(PlatDto platDto){
        platService.save(platDto);
        return "redirect:/plats";
    }

    @PostMapping("/delete/{id}")
    public String deletePlat(@PathVariable Long id){
        List<PlatDto> allPlats = new ArrayList<>(platService.getAll());
        List<MenuDto> allMenus = menuService.getAll();

        List<PlatDto> platsModifiable = new ArrayList<>(allPlats);
        for (PlatDto platDto : allPlats) {
            for (MenuDto menuDto : allMenus) {
                if (menuDto.getPlat().getId() == platDto.getId()) {
                    platsModifiable.remove(platDto);
                    menuService.delete(menuDto.getId());
                    platService.delete(platDto.getId());
                    break;
                }
            }
        }
        platService.delete(id);
        return "redirect:/plats";
    }

    @GetMapping("/{id}")
    public String showUpdatePlatForm(Model model, @PathVariable Long id){
        Optional<PlatDto> platDto = platService.findOne(id);
        if(platDto.isPresent()){
            model.addAttribute("plat", platDto.get());
            return "plat/forms";
        }else {
            return "redirect:/plats";
        }
    }


}
