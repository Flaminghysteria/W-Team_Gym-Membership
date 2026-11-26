import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static boolean saveUser(String name, String email, String phone, String username, String password) {
        boolean success=findUser(name ,email , phone ,username);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))){
            bw.write(name+" "+email+" "+phone+" "+username+" "+password+" \n");
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return false;
        }
        return true;
    }
    public static ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try(BufferedReader br = new BufferedReader(new FileReader("users.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                User user = new User(parts[0], parts[1], (parts[2]), parts[3], parts[4]);
                users.add(user);
            }
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return null;
        }
        return users;
    }
    public static boolean findUser(String name, String email, String phone, String username){
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                if(parts[0].equals(name)) return true;
                if(parts[1].equals(email)) return true;
                if(parts[2].equals(phone)) return true;
                if(parts[3].equals(username)) return true;
            }
        }catch (IOException e){
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return false;
        }
        return false;
    }
}
