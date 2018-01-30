package fr.groot.demoCockroachBD;

import fr.groot.demoCockroachBD.Model.Author;
import fr.groot.demoCockroachBD.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaQuery;

@SpringBootApplication
public class DemoCockroachBdApplication {

	public static final SessionFactory sessionFactory =
			new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Book.class)
					.addAnnotatedClass(Author.class)
					.buildSessionFactory();

	public static void generateDB() {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Author author1 = new Author(1, "Stephen", "King");
			session.save(author1);
			session.save(new Book(1, "Ça", author1));
			session.save(new Book(2, "Shining", author1));
			session.save(new Book(3, "Under The Dome", author1));

			Author author2 = new Author(2, "Christopher", "Paolini");
			session.save(author2);
			session.save(new Book(4, "Eragon", author2));
			session.save(new Book(5, "L'Aîné", author2));
			session.save(new Book(6, "Brisingr", author2));
			session.save(new Book(7, "L'Héritage", author2));

			Author author3 = new Author(3, "Jean-Baptiste", "Poquelin (Molière)");
			session.save(author3);
			session.save(new Book(8, "Les Précieuses ridicules", author3));
			session.save(new Book(9, "Le Médecin malgré lui", author3));
			session.save(new Book(10, "L'Avare", author3));
			session.save(new Book(11, "Le Tartuffe ou l'Imposteur", author3));
			session.save(new Book(12, "Le Bourgeois gentilhomme", author3));

			Author author4 = new Author(4, "Steven", "Gould");
			session.save(author4);
			session.save(new Book(13, "Jumper", author4));
			session.save(new Book(14, "Reflex", author4));

			Author author5 = new Author(5, "John", "Lang");
			session.save(author5);
			session.save(new Book(15, "Le Donjon de Naheulbeuk : la Couette de l’Oubli", author5));
			session.save(new Book(16, "Le Donjon de Naheulbeuk : l'Orbe de Xaraz", author5));
			session.save(new Book(17, "Le Donjon de Naheulbeuk : le Conseil de Suak", author5));
			session.save(new Book(18, "Le Donjon de Naheulbeuk : à l'Aventure, compagnons", author5));
			session.save(new Book(19, "Le Donjon de Naheulbeuk : Chaos sous la montagne", author5));
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoCockroachBdApplication.class, args);

		// Generate Database
		generateDB();

		/*
		Session session = sessionFactory.openSession();

		try {
			// Insert two rows into the "accounts" table.
			session.beginTransaction();
			session.save(new Account(3, 3000));
			session.save(new Account(4, 350));
			session.getTransaction().commit();

			// Print out the balances.
			CriteriaQuery<Account> query = session.getCriteriaBuilder().createQuery(Account.class);
			query.select(query.from(Account.class));
			for (Account account : session.createQuery(query).getResultList()) {
				System.out.printf("%d %d\n", account.id, account.balance);
			}
		} finally {
			session.close();
			sessionFactory.close();
		}
		*/
	}
}
