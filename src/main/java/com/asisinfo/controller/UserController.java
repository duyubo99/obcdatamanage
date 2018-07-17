package com.asisinfo.controller;

import com.asisinfo.domain.User;
import com.asisinfo.service.UserService;
import com.asisinfo.utils.JsonUtil;
import com.asisinfo.utils.MyPage;
import com.asisinfo.vo.UserVo;
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

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/insertUser")
    public String addEmp(User user){
        //保存员工
        userService.save(user);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/user/toUserlistPage";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        User u = userService.getUser(id);
        model.addAttribute("user",u);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/update_user";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/user")
    public String updateEmployee(User user){
        userService.save(user);
        return "redirect:/userlist";
    }
    //员工删除
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        userService.delete(id);
        return "redirect:/userlist";
    }
}
