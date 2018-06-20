package com.asisinfo.repository;

import com.asisinfo.domain.DataLog;
import com.asisinfo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataLogRepository extends JpaRepository<DataLog,Integer> {
}
