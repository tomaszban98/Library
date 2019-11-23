package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Author;
import pl.sda.entities.Book;
import util.HibernateUtil;

public class BookRepository {

    public void save(Book book) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void cleanUp() {
        HibernateUtil.cleanUp();
    }
}
