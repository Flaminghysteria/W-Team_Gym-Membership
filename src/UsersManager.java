import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UsersManager {
    private final ArrayList<User> users;
    public UsersManager(){
        users=FileHandler.loadUsers();
    }
    public boolean signup(String name, String email, long phone, String username, String password){
        boolean success= FileHandler.saveUser(name, email, phone, username, password);
        if(!success) return false;
        User user=new User(name,email,phone,username,password);
        users.add(user);
        return true;
    }
    public boolean login(String userInput, String password){
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                if(parts[0].equals(userInput)||parts[1].equals(userInput)||parts[2].equals((String.valueOf(userInput)))||parts[3].equals(userInput)){
                    if(parts[4].equals(password)) return true;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
    public ArrayList<User> getUsers(){
        return users;
    }
}
