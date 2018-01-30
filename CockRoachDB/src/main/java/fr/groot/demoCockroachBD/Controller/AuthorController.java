package fr.groot.demoCockroachBD.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fr.groot.demoCockroachBD.Model.Author;
import fr.groot.demoCockroachBD.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public Collection<Author> getAllAuthors() {
        return this.authorService.getAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable("id") long id) {
        return this.authorService.getById(id);
    }

    @PostMapping("/authors")
    public String addAuthor(@RequestParam(name = "id") long id, @RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname) {
        authorService.addAuthor(id, firstname, lastname);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("success", true);

        return data.toString();
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable("id") long id) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("success", false);

        if(this.authorService.deleteAuthor(id)) {
            data.put("success", true);
        }

        return data.toString();
    }
}

