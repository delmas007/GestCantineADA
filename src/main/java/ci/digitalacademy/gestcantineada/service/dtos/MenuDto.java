package ci.digitalacademy.gestcantineada.service.dtos;

import ci.digitalacademy.gestcantineada.model.Plat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MenuDto {
    private Long id;
    private Date creation_date;
    private Plat plat;
}
