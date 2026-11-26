import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void fileCreator(){
        File file = new File("users.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            new ErrorHandler(null).JOptionPaneError("Could not create users.txt" + e.getMessage());
        }
    }
    public static boolean saveUser(String name, String email, String phone, String username, String password) {
        fileCreator();

        if(findUser(name, email, phone, username)){
            return false;
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))){
            bw.write(name+"|"+email+"|"+phone+"|"+username+"|"+password);
            bw.newLine();
            return true;
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return false;
        }
    }
    public static ArrayList<User> loadUsers(){
        fileCreator();
        ArrayList<User> users = new ArrayList<User>();
        try(BufferedReader br = new BufferedReader(new FileReader("users.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split("\\|");
                if(parts.length >= 5){
                    User user = new User(parts[0], parts[1], (parts[2]), parts[3], parts[4]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return null;
        }
        return users;
    }
    public static boolean findUser(String name, String email, String phone, String username){
        for(User user : loadUsers()){
            if(user.getName().equals(name) ||
               user.getEmail().equals(email) ||
               user.getPhone().equals(phone) ||
               user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
