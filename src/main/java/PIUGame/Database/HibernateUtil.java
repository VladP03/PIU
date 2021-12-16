package PIUGame.Database;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public final class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return sessionFactory;
    }

    public static void startSession() {
        try {
            getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
