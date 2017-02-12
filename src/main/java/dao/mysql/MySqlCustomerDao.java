package dao.mysql;

import dao.CustomerDao;
import dao.DaoFactory;
import domain.Customer;

import java.sql.*;

/**
 * Created by User on 11.02.2017.
 */
public class MySqlCustomerDao implements CustomerDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();


    public Customer create(String name, String birthday, String phone, String login, String password) throws Exception {
        String sql = "insert into online_customer.customer (name ,phone, login , password ,birthday) values (?,?,?,?,?);";
        Customer customer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();

            try {
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phone);
                preparedStatement.setString(3, login);
                preparedStatement.setString(4, password);
                preparedStatement.setString(5, birthday);
                preparedStatement.execute();
                try {
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    customer = new Customer(resultSet.getString("name")
                            , resultSet.getString("phone")
                            , resultSet.getString("login")
                            , resultSet.getString("password")
                            , resultSet.getString("birthday"));
                } finally {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {

        } finally {
            connection.close();
        }
        return customer;
    }

    public Customer read(String login) throws Exception {
        String sql = "SELECT * FROM online_customer.customer as c where c.name = ?;";
        Customer customer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, login);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {

                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String logi = resultSet.getString("login");
                    String password = resultSet.getString("password");
                    String birthday = resultSet.getString("birthday");
                    customer = new Customer(name , phone , logi , password , birthday);
                }
                    resultSet.close();
        preparedStatement.close();
        connection.close();

                return customer;
            }

    public Customer update(String name, String birthday, String phone, String login, String password) {
        return null;
    }
}
