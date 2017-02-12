import dao.DaoFactory;
import domain.Customer;
import domain.LibrayManagerImpl;

/**
 * Created by User on 09.02.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        DaoFactory daoFactory = DaoFactory.getInstance();
        daoFactory.getConnection();
        LibrayManagerImpl manager =new LibrayManagerImpl();
      //  manager.createAccaount("Narnia" ,"1995.02.08", "8775192" ,"nuris" ,"123456");
       Customer customer = manager.readAccaount("Nurislam");
        System.out.println(customer.getName() +" "+ customer.getPhone()+ " "+ customer.getBirthday()+ " "+ customer.getLogin());


    }
}
