package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    //поле создали только чтобы проинициализировать sessionFactory
    static {
        // если не получится найти наш hibernate.cfg.xml
        try {
            //на этом этапе(Configuration()) он будет искать файл hibenate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch(Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
