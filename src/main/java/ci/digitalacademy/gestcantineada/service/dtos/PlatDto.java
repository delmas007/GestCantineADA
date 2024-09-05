package ci.digitalacademy.gestcantineada.service.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatDto {
    private Long id;
    private String name;
    private String summary;
}
