import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static File fileCreator(){
        File file = new File("users.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
        }
        return file;
    }
    public static boolean saveUser(String name, String email, String phone, String username, String password) {
        if(findUser(name, email, phone, username)){
            return false;
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileCreator(),true))){
            bw.write(name+"|"+email+"|"+phone+"|"+username+"|"+password);
            bw.newLine();
            return true;
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return false;
        }
    }
    public static ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileCreator()))){
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

    public static boolean removeUser(User user){
        if(!findUser(user.getName(),user.getEmail(),user.getPhone(),user.getUsername())){
            new ErrorHandler(null).JOptionPaneError("Account does not exist.");
            return false;
        }
        ArrayList<String> lines=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileCreator()))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split("\\|");
                if(parts[0].equals(user.getName())
                        && parts[1].equals(user.getEmail())
                        && parts[2].equals(user.getPhone())
                        && parts[3].equals(user.getUsername()))
                {
                    continue;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return false;
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileCreator()))){
            for(String s: lines){
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            new ErrorHandler(null).JOptionPaneError(e.getMessage());
            return false;
        }
        return true;
    }
}
