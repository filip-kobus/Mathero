package Auth.User;

import Auth.PasswordEncrypter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String Login;

    @Email
    private  String Email;

    private int SpentTime;

    private String Password;

    @Transient
    PasswordEncrypter passwordEncrypter = new PasswordEncrypter();


    public User(String Login, String Email, int SpentTime, String Password) {
        this.Login = Login;
        this.Email = Email;
        this.SpentTime = SpentTime;
        this.Password = Password;
    }

    public User(String Login, String Email, String Password) {
        this.Login = Login;
        this.Email = Email;
        this.SpentTime = 0;
        this.Password = passwordEncrypter.encryptPassword(Password);
    }

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public  String getLogin() {
        return Login;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setSpentTime(int SpentTime) {
        this.SpentTime = SpentTime;
    }

    public int getSpentTime() {
        return SpentTime;
    }

    public void setPassword(String Password) {
        this.Password = passwordEncrypter.encryptPassword(Password);
    }

    public String getPassword() {
        return Password;
    }
}
