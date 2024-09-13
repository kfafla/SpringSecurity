package top.xmy.springboot.logging.springboot.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.xmy.springboot.logging.springboot.thymeleaf.model.UserList;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserlistController {
    private List<UserList> users=new ArrayList<>();

    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("userlist",users);
        return "userlist";
    }
    @PostMapping("/addUserlist")
    public String addUserlist(@RequestParam String name,String email){
        Long id=(long)(users.size()+1);
        UserList userlist=new UserList(id,name,email);
        users.add(userlist);
        return "redirect:/userList";
    }
}
