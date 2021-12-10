package PIUGame.Database.Table;

import PIUGame.Database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class RecordDAO {

    public void saveRecord(Record record) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(record);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ArrayList<Record> getRecords() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (ArrayList<Record>) session.createQuery("from Record ", Record.class).list();
        }
    }
}
