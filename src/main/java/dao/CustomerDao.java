package dao;

import domain.Customer;


/**
 * Created by User on 11.02.2017.
 */
public interface CustomerDao {

    Customer create (String name , String birthday , String phone , String login ,String password) throws Exception;

    Customer read (String login) throws Exception;

    Customer update(String name , String birthday , String phone , String login ,String password);
}
