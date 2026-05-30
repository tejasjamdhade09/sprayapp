package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farm.entity.SprayPesticide;

public interface SprayPesticideRepository extends JpaRepository<SprayPesticide, Long> {
}
