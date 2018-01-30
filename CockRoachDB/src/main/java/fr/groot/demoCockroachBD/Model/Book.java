package fr.groot.demoCockroachBD.Model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Books")
@Table(name="books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {
    @Id
    private long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonManagedReference
    private Author author;

    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(long id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("id", id);
        data.put("title", title);

        ObjectNode dataAuthor = mapper.createObjectNode();
        dataAuthor.put("firstname", author.getFirstname());
        dataAuthor.put("lastname", author.getLastname());
        //data.put("author", dataAuthor);

        return data.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
