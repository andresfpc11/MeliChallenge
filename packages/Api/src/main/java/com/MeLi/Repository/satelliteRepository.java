package com.MeLi.Repository;
import com.MeLi.model.Satellite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface satelliteRepository extends CrudRepository<Satellite, Long> {
}
