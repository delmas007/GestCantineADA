package ci.digitalacademy.gestcantineada.service.imp;

import ci.digitalacademy.gestcantineada.repository.MenuRepository;
import ci.digitalacademy.gestcantineada.service.MenuService;
import ci.digitalacademy.gestcantineada.service.dtos.MenuDto;
import ci.digitalacademy.gestcantineada.service.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImp implements MenuService {
    private final MenuRepository menuRepository;
    private  final MenuMapper menuMapper;
    @Override
    public MenuDto save(MenuDto menuDto) {
        return menuMapper.fromEntity(menuRepository.save(menuMapper.toEntity(menuDto)));
    }

    @Override
    public MenuDto update(MenuDto menuDto) {
        return findOne(menuDto.getId()).map(existingMenu -> {
            existingMenu.setPlat(menuDto.getPlat());
            return save(existingMenu);
        }).orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<MenuDto> getAll() {
        return menuRepository.findAll().stream().map(menu -> {
            return menuMapper.fromEntity(menu);
        }).toList();
    }

    @Override
    public Optional<MenuDto> findOne(Long id) {
        return menuRepository.findById(id).map(menu -> {
            return menuMapper.fromEntity(menu);
        });
    }
}
