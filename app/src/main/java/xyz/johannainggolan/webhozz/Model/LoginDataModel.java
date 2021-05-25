package xyz.johannainggolan.webhozz.Model;

public class LoginDataModel {
    String email=null;
    String password=null;

    //encapsulation
    public LoginDataModel(String email, String password){
        this.email = email ;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
