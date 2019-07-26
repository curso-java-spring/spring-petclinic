package br.com.dbserver.samples.sensorumidade.plant;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends Repository<Plant, Integer> {

    Collection<Plant> findAll();
    
    @Query("SELECT plant FROM Plant plant JOIN fetch plant.sensors WHERE plant.id =:id")
    @Transactional(readOnly = true)
    Plant findById(@Param("id") Integer id);
    
    @Query("SELECT ptype FROM Type ptype ORDER BY ptype.name")
    @Transactional(readOnly = true)
    List<Type> findPlantTypes();
    
    
    void save(Plant plant);
}