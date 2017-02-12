package domain;

/**
 * Created by User on 11.02.2017.
 */
public class Customer  {
    private String name;
    private String birthday;
    private String phone;
    private String login;
    private String password;

    public  Customer(){

    }
    public Customer(String name , String birthday , String phone , String login ,String password){
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
