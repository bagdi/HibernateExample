package dao.impl;

import dao.ContactDao;
import org.hibernate.Session;
import table.Contact;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class ContactDaoImpl implements ContactDao {

    @Override
    public void addContact(Contact contact) throws SQLException {
        //используем сессию
        Session session = null;
        try{
            //с помощью HibernateUtil получим фабрику сессий, сразу откроем сессию
            session = HibernateUtil.getSessionFactory().openSession();
            //начинаем транзакцию
            session.beginTransaction();
            //далее мы что то делаем
            session.save(contact);
            session.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //введем блок finally, чтобы, если возникнет исключение в блоке try, код довыполнился(закрылась сессия)
        finally {
            if((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public void deleteContact(Contact contact) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(contact);
            session.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public Contact getContact(int id) throws SQLException {
        Contact result = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            //в session есть такой метод load, который принимает класс и id, но этот  метод стоит использовать только тогда,
            //когда мы вернем result до закрытия сессии, в противном случае используем get()
            //возвращает нам Object, поэтому нужно привети к Contact
            result = (Contact) session.get(Contact.class, id); //load(Contact.class, id);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<Contact> listContact() throws SQLException {
        List<Contact> contactList = null;

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            //воспользуемся методом createCriteria, который принимает класс
            //list возврыщает список всех существующих Contact
            contactList = session.createCriteria(Contact.class).list();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return contactList;
    }
}
