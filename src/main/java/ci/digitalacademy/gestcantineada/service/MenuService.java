package ci.digitalacademy.gestcantineada.service;

import ci.digitalacademy.gestcantineada.service.dtos.MenuDto;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    MenuDto save(MenuDto menuDto);
    MenuDto update(MenuDto menuDto);
    void delete(Long id);
    List<MenuDto> getAll();
    Optional<MenuDto> findOne(Long id);
}
