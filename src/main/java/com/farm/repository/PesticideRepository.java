package com.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.farm.entity.Pesticide;

@Repository
public interface PesticideRepository extends JpaRepository<Pesticide, Long> {

    // Derived query method to find pesticides where qty < threshold
    List<Pesticide> findByQtyLessThan(Double threshold);
}