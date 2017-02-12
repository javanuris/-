package domain;

/**
 * Created by User on 11.02.2017.
 */
public interface LibraryManager {

    Customer createAccaount(String name , String birthday , String phone , String login ,String password) throws Exception;

}
