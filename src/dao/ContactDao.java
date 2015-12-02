package dao;

import table.Contact;
import java.sql.SQLException;
import java.util.List;

public interface ContactDao {
    public void addContact(Contact contact) throws SQLException;
    public void deleteContact(Contact contact) throws SQLException;
    public Contact getContact(int id) throws SQLException;
    public List<Contact> listContact() throws SQLException;
}
