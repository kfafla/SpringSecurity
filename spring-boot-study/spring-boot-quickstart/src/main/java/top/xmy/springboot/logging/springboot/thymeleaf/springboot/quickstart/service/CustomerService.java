package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.enums.RequestType;

/**
 * @author mqxu
 * @date 2024/9/2
 * @description CustomerService
 **/
@Service
public class CustomerService {
    public String handleRequest(RequestType requestType) {
        return switch (requestType) {
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTION -> handleSuggestion();
        };
    }

    private String handleQuery() {
        return "查询请求";
    }

    private String handleComplaint() {
        return "投诉请求";
    }

    private String handleSuggestion() {
        return "建议请求";
    }
}
