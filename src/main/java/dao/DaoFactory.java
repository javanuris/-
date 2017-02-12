package dao;

import dao.mysql.MySqlCustomerDao;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by User on 11.02.2017.
 */
public class DaoFactory {
    private static DaoFactory daoFactory;
    private static String type;
    private String user;
    private String password;
    private String url;
    private String driver;
    static Logger logger = Logger.getLogger(DaoFactory.class.getName());
    private DaoFactory(){
        loadProperties();
        try {

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("Not connecting to JDBC Driver" ,e);

        }
    }
    public static DaoFactory getInstance(){
        if(null == daoFactory){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public Connection getConnection() throws Exception {
        logger.info("Getting connect");
        try {
            return DriverManager.getConnection(url,"root" , "root");
        }catch (Exception e){
            logger.error("Didnt connecting to databases" ,e);
            throw  new Exception("No db connect");


        }

    }

    public CustomerDao getCustomerDao(){
        if(type.equalsIgnoreCase("mysql")){
            logger.info("Connecting to MySQlCustomDao");
            return new MySqlCustomerDao();
        }else{
            return new MySqlCustomerDao();
        }
    }
    private void loadProperties(){
        logger.info("Loading setting for database connectioin");
        Properties properties = new Properties();
        try {
            properties.load(DaoFactory.class.getResourceAsStream("/db.properties"));
            type = properties.getProperty("type");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            logger.error("didnt load properties");
            e.printStackTrace();
        }

    }

}
