package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farm.entity.SprayRecord;

public interface SprayRecordRepository extends JpaRepository<SprayRecord, Long> {
}
