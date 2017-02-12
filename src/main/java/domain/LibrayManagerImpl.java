package domain;

import dao.CustomerDao;
import dao.DaoFactory;

/**
 * Created by User on 11.02.2017.
 */
public class LibrayManagerImpl implements LibraryManager {
    private CustomerDao customerDAO;
    private DaoFactory daoFactory;

    public LibrayManagerImpl(){
        daoFactory = DaoFactory.getInstance();
        customerDAO = daoFactory.getCustomerDao();
    }

    public Customer createAccaount(String name, String birthday, String phone, String login, String password) throws Exception {
        return customerDAO.create(name , birthday , phone , login , password);
    }
    public Customer readAccaount(String login) throws Exception {
        return customerDAO.read(login);
    }

}
