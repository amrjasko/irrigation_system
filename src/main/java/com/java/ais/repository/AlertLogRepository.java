package com.java.ais.repository;

import com.java.ais.model.AlertLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertLogRepository extends JpaRepository<AlertLog,Long> {
}
