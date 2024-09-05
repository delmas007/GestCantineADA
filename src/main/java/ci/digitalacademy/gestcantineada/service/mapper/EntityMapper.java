package ci.digitalacademy.gestcantineada.service.mapper;

public interface EntityMapper<D, E> {
    D fromEntity(E entity);
    E toEntity(D dto);

}
