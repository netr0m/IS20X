package is20x;
 
import java.util.HashMap;
import java.util.Map;
 
public class User {
 
    private static final Map<String, User> USERS = new HashMap<String, User>();
 
    public static User of(String id) {
        User user = USERS.get(id);
        if (user == null) {
            user = new User(id);
            USERS.put(id, user);
        }
        return user;
    }
 
    private User(String id) {
        this.id = id;
    }
    private String id;
 
    public String getId() {
        return id;
    }
    private String name = "";
    private String email = "";
    private boolean teacher = false;
    private boolean admin = false;
    private String password = "1234";
    
    /**
     */
    public String getName() {
        return name;
    }
 
    /**
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     */
    public String getEmail() {
        return email;
    }
 
    /**
     */
    public void setEmail(String email) {
        this.email = email;
    }
 
    /**
     */
    public boolean isAdmin() {
        return admin;
    }
 
    /**
     */
    public void setAdmin(boolean admin) {
        if (this.isAdmin()) {
            this.admin = admin;
        }
    }
    
    /**
     */
    public boolean isTeacher() {
        return teacher;
    }
 
    /**
     */
    public void setTeacher(boolean teacher) {
        if (this.isAdmin()) {
            this.teacher = teacher;
        }
    }
private String oldPassword;
private String newPassword;
    /**
     */
    public void setPassword(String oldPassword, String newPassword) {
        if (this.oldPassword == this.password) {
        this.password = newPassword;
        }
        else {
        }
        }
    }