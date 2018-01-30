package fr.groot.demoCockroachBD.Model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Authors")
@Table(name="authors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author implements Serializable {
    @Id
    private long id;

    private String firstname;
    private String lastname;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Book> books = new HashSet<>(0);

    public Author(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Author(String firstname, String lastname, Set<Book> books) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }

    public Author() {
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("id", id);
        data.put("firstname", firstname);
        data.put("lastname", lastname);
        ArrayNode array = mapper.valueToTree(books);
        //data.putArray("books").addAll(array);

        return data.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
