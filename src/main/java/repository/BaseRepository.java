package repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends org.springframework.data.repository.Repository<T,ID> {
    void deleteById(ID id);
    boolean existsById(ID id);

    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T persisted);
}
