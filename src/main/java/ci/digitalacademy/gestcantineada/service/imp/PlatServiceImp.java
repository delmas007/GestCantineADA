package ci.digitalacademy.gestcantineada.service.imp;

import ci.digitalacademy.gestcantineada.repository.MenuRepository;
import ci.digitalacademy.gestcantineada.repository.PlatRepository;
import ci.digitalacademy.gestcantineada.service.MenuService;
import ci.digitalacademy.gestcantineada.service.PlatService;
import ci.digitalacademy.gestcantineada.service.dtos.MenuDto;
import ci.digitalacademy.gestcantineada.service.dtos.PlatDto;
import ci.digitalacademy.gestcantineada.service.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatServiceImp implements PlatService {
    private final PlatRepository platRepository;
    private final PlatMapper platMapper;


    @Override
    public PlatDto save(PlatDto platDto) {
        return platMapper.fromEntity(platRepository.save(platMapper.toEntity(platDto)));
    }

    @Override
    public PlatDto update(PlatDto platDto) {
        return findOne(platDto.getId()).map(existingPlat -> {
            existingPlat.setName(platDto.getName());
            return save(existingPlat);
        }).orElseThrow(() -> new RuntimeException("Plat not found"));
    }

    @Override
    public void delete(Long id) {
        platRepository.deleteById(id);
    }

    @Override
    public List<PlatDto> getAll() {
        return platRepository.findAll().stream().map(plat -> {
            return platMapper.fromEntity(plat);
        }).toList();
    }

    @Override
    public Optional<PlatDto> findOne(Long id) {
        return platRepository.findById(id).map(plat -> {
            return platMapper.fromEntity(plat);
        });
    }
}
