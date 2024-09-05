package ci.digitalacademy.gestcantineada.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_creation")
    private Date creation_date;

    @OneToOne
    @JoinColumn(name = "plat_id")
    private Plat plat;
}
