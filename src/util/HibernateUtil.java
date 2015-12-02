package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    //���� ������� ������ ����� ������������������� sessionFactory
    static {
        // ���� �� ��������� ����� ��� hibernate.cfg.xml
        try {
            //�� ���� �����(Configuration()) �� ����� ������ ���� hibenate.cfg.xml
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
