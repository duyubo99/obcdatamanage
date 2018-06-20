package com.asisinfo.controller;

import com.asisinfo.domain.DataLog;
import com.asisinfo.domain.User;
import com.asisinfo.service.DataLogService;
import com.asisinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DataLogController {

    @Autowired
    private DataLogService dataLogService;

    @GetMapping("dataLogs")
    public String userList(Model model){
        List<DataLog> all = dataLogService.findAll();
        model.addAttribute("dls",all);
        return "dataLog/list";
    }

}
