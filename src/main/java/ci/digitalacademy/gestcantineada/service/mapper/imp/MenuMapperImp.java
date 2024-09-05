package ci.digitalacademy.gestcantineada.service.mapper.imp;

import ci.digitalacademy.gestcantineada.model.Menu;
import ci.digitalacademy.gestcantineada.service.dtos.MenuDto;
import ci.digitalacademy.gestcantineada.service.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuMapperImp implements MenuMapper {
    private final ModelMapper modelMapper;

    @Override
    public MenuDto fromEntity(Menu entity) {
        return modelMapper.map(entity, MenuDto.class);
    }

    @Override
    public Menu toEntity(MenuDto dto) {
        return modelMapper.map(dto, Menu.class);
    }
}
