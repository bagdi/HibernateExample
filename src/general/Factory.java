package general;

import dao.ContactDao;
import dao.impl.ContactDaoImpl;

public class Factory {
    //всегда static
    public static Factory instance = new Factory();
    private ContactDao contactDao;

    private Factory() {
    }

    public static Factory getInstance() {
        return Factory.instance;
    }

    public ContactDao getContactDao() {
        if(contactDao == null) {
            contactDao = new ContactDaoImpl();
        }
        return contactDao;
    }
}
