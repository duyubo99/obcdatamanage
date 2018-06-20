package com.asisinfo.service;

import com.asisinfo.domain.DataLog;
import com.asisinfo.domain.User;
import com.asisinfo.repository.DataLogRepository;
import com.asisinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataLogService {

    @Autowired
    private DataLogRepository dataLogRepository;

    public List<DataLog> findAll(){
        return dataLogRepository.findAll();
    }


}
