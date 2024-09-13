package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.enums.RequestType;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service.CustomerService;

/**
 * @author mqxu
 * @date 2024/9/2
 * @description CustomerController
 **/
@RestController
@RequestMapping("/requests")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/{type}")
    public String handleRequest(@PathVariable RequestType type) {
        return customerService.handleRequest(type);
    }
}
