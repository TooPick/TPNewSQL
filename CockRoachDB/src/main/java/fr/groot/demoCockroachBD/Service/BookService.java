package fr.groot.demoCockroachBD.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.groot.demoCockroachBD.DemoCockroachBdApplication;
import fr.groot.demoCockroachBD.Model.Author;
import fr.groot.demoCockroachBD.Model.Book;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Service
public class BookService {

    public void addBook(Book book) {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void addBook(long id, String title, Author author) {
        Book book = new Book(id, title, author);
        this.addBook(book);
    }

    public Book getById(long id) {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();
        Book result = session.get(Book.class, id);
        session.close();

        return result;
    }

    public Collection<Book> getAll() {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();
        CriteriaQuery<Book> query = session.getCriteriaBuilder().createQuery(Book.class);
        query.select(query.from(Book.class));

        Collection<Book> result = session.createQuery(query).getResultList();
        session.close();

        return result;
    }

    public boolean deleteBook(long id) {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();

        Book book = null;
        book = this.getById(id);

        if(book != null) {
            try {
                session.beginTransaction();
                session.remove(book);
                session.getTransaction().commit();
            } finally {
                session.close();
            }

            return true;
        }

        return false;
    }
}
