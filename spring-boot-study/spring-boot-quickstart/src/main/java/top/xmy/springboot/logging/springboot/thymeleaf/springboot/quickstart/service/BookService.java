package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service;
import org.springframework.stereotype.Service;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.dto.BookDTO;

import java.util.List;

/**
 * @author mqxu
 * @date 2024/9/2
 * @description BookService
 **/
@Service
public class BookService {
    public List<BookDTO> getAllBooks() {
        return List.of(
                new BookDTO(1L, "Java Programming", "Alice", 29.99),
                new BookDTO(2L, "Spring Boot Action", "Bob", 39.99)
        );
    }
}
