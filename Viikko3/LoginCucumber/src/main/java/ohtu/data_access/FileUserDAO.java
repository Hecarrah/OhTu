package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {

    private String filename;
    private List<User> users;
    private FileWriter fw;

    public FileUserDAO() {
    }

    public FileUserDAO(String filename) throws IOException {
        this.users = new ArrayList<>();
        this.filename = filename;
        if (!readFile()) {
            System.out.println("Salasanoja ei löydetty");
        }
    }

    private boolean readFile() {
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                users.add(new User(data[0], data[1]));
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

    @Override
    public void add(User user) {
        users.add(user);
        try {
            fw = new FileWriter(filename, true);
            fw.write(user.getUsername() + " " + user.getPassword() + " ");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<User> listAll() {
        return users;
    }

}
