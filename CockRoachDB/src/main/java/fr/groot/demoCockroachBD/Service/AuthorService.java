package fr.groot.demoCockroachBD.Service;

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
public class AuthorService {

    public void addAuthor(Author author) {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void addAuthor(long id, String firstname, String lastname) {
        Author author = new Author(id, firstname, lastname);
        this.addAuthor(author);
    }

    public Author getById(long id) {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();
        Author result = session.get(Author.class, id);
        session.close();

        return result;
    }

    public Collection<Author> getAll() {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();
        CriteriaQuery<Author> query = session.getCriteriaBuilder().createQuery(Author.class);
        query.select(query.from(Author.class));

        Collection<Author> result = session.createQuery(query).getResultList();
        session.close();

        return result;
    }

    public boolean deleteAuthor(long id) {
        Session session = DemoCockroachBdApplication.sessionFactory.openSession();

        Author author = null;
        author = this.getById(id);

        if(author != null) {
            try {
                session.beginTransaction();
                session.remove(author);
                session.getTransaction().commit();
            } finally {
                session.close();
            }

            return true;
        }

        return false;
    }
}
