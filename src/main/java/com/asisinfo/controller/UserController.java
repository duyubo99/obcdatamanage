package com.asisinfo.controller;

import com.asisinfo.domain.User;
import com.asisinfo.service.UserService;
import com.asisinfo.utils.JsonUtil;
import com.asisinfo.utils.MyPage;
import com.asisinfo.vo.UserVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController{
    @Autowired
    private UserService userService;

    /**
     * 加载User数据
     */
    @PostMapping("getUserlist")
    @ResponseBody
    public String getUserList(@RequestBody MyPage<User,UserVo> page){
        page =  userService.findAll(page);
        return JsonUtil.pageToJson(page);
    }
    /**
     * 到达userList页面
     */
    @GetMapping("toUserlistPage")
    public String toUserList(Model model){
        return "user/list";
    }

    //员工添加、修改
    @PostMapping("/updateUser")
    public String addEmp(User user){
        userService.save(user);
        return "redirect:/user/toUserlistPage";
    }

    //来到修改页面
    @GetMapping("/toEditUserPage/{id}")
    @ResponseBody
    public String toEditUser(@PathVariable("id") Integer id){
        User u = userService.getUser(id);
        return JSONObject.fromObject(u).toString();
    }

    //员工删除
    @GetMapping("/doDelete")
    @ResponseBody
    public String deleteEmployee(String ids){
        userService.deleteBatchByid(ids);
        return "success";
    }
}
