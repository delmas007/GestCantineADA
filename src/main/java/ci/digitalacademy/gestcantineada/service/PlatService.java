package ci.digitalacademy.gestcantineada.service;

import ci.digitalacademy.gestcantineada.service.dtos.PlatDto;

import java.util.List;
import java.util.Optional;

public interface PlatService {
    PlatDto save(PlatDto platDto);
    PlatDto update(PlatDto platDto);
    void delete(Long id);
    List<PlatDto> getAll();
    Optional<PlatDto> findOne(Long id);
}
