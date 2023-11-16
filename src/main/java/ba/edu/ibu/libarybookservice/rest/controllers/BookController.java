package ba.edu.ibu.libarybookservice.rest.controllers;

import ba.edu.ibu.libarybookservice.core.model.Book;
import ba.edu.ibu.libarybookservice.core.service.BookService;
import ba.edu.ibu.libarybookservice.rest.dto.BookRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    private Environment environment;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<Book> addBook(@RequestBody BookRequestDTO book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        System.out.println("Server triggered: " + environment.getProperty("local.server.port"));
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody BookRequestDTO book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
