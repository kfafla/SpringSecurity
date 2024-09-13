package top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.dto.BookDTO;
import top.xmy.springboot.logging.springboot.thymeleaf.springboot.quickstart.service.BookService;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getAllBooks();
    }

}