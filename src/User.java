import javax.swing.*;
import java.io.*;
import java.util.*;
public abstract class User {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public User(String name, String email, String phone, String username, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }


    public boolean login(String user, String pass){
        try(BufferedReader br= new BufferedReader(new FileReader("users.txt"))){
            String line;
            while((line= br.readLine())!=null){
                String[] parts = line.split(",");
                if (parts[0].equals(user)||parts[1].equals(user)) {
                    if(parts[2].equals(pass)){
                        return true;
                    }
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void logout(){

    }

    public void updateProfile(){

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password;}

}
