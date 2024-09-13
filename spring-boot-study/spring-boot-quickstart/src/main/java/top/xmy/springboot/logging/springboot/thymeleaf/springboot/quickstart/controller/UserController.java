package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service.UserService;

import java.util.List;

/**
 * @author mqxu
 * @date 2024/9/2
 * @description UserController
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/adults")
    public List<String> getAdultsUserName() {
        return userService.getAdultsUserName();
    }
}
