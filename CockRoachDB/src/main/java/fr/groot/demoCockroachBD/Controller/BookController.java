package fr.groot.demoCockroachBD.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fr.groot.demoCockroachBD.Model.Author;
import fr.groot.demoCockroachBD.Model.Book;
import fr.groot.demoCockroachBD.Service.AuthorService;
import fr.groot.demoCockroachBD.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/books")
    public Collection<Book> getAllBooks() {
        return this.bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") long id) {
        return this.bookService.getById(id);
    }

    @PostMapping("/books")
    public String addComment(@RequestParam(name = "id") long id, @RequestParam(name = "title") String title, @RequestParam(name= "author_id") long author_id) {
        Author author = null;

        author = this.authorService.getById(author_id);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("success", false);

        if(author != null) {
            bookService.addBook(id, title, author);

            data.put("success", true);
        }

        return data.toString();
    }

    @DeleteMapping("/books/{id}")
    public String deleteAuthor(@PathVariable("id") long id) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("success", false);

        if(this.bookService.deleteBook(id)) {
            data.put("success", true);
        }

        return data.toString();
    }
}
