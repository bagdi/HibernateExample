package general;

import dao.ContactDao;
import table.Contact;

import java.sql.SQLException;
import java.util.List;

public class Project {

    public static void main(String[] args) throws SQLException {
        //получим наш Dao
        Factory factory = Factory.getInstance();
        ContactDao contactDao = factory.getContactDao();

        /*Contact contact = new Contact();
        contact.setFirstName("Ludmila");
        contact.setLastName("Rutkova");
        contact.setEmail("luda_54@mail.ru");
        contact.setThelephone("+375296068518");

        contactDao.addContact(contact);
        */

        List<Contact> list = contactDao.listContact();

        System.out.println("ID| First Name| Last Name|    Email|        Thelephone");

        for(Contact cont : list) {
            System.out.println(cont.getId() + "|    " + cont.getFirstName() + "|    " + cont.getLastName() + "| " + cont.getEmail() + "| " + cont.getThelephone());
        }
    }
}
