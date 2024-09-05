package ci.digitalacademy.gestcantineada.service.mapper.imp;

import ci.digitalacademy.gestcantineada.model.Plat;
import ci.digitalacademy.gestcantineada.service.dtos.PlatDto;
import ci.digitalacademy.gestcantineada.service.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlatMapperImp implements PlatMapper {
    private final ModelMapper modelMapper;
    @Override
    public PlatDto fromEntity(Plat entity) {
        return modelMapper.map(entity, PlatDto.class);
    }

    @Override
    public Plat toEntity(PlatDto dto) {
        return modelMapper.map(dto, Plat.class);
    }
}
