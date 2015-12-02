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
        //���������� ������
        Session session = null;
        try{
            //� ������� HibernateUtil ������� ������� ������, ����� ������� ������
            session = HibernateUtil.getSessionFactory().openSession();
            //�������� ����������
            session.beginTransaction();
            //����� �� ��� �� ������
            session.save(contact);
            session.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //������ ���� finally, �����, ���� ��������� ���������� � ����� try, ��� ������������(��������� ������)
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
            //� session ���� ����� ����� load, ������� ��������� ����� � id, �� ����  ����� ����� ������������ ������ �����,
            //����� �� ������ result �� �������� ������, � ��������� ������ ���������� get()
            //���������� ��� Object, ������� ����� ������� � Contact
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
            //������������� ������� createCriteria, ������� ��������� �����
            //list ���������� ������ ���� ������������ Contact
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
