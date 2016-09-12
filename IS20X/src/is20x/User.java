package is20x;
 
public class User {
    private int studentID;
    private String name;
    private String username;
    private String password;
    private String email;
    
    public int getID() {
        return studentID;
    }
    
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
    public String getUsername() {
        return username;
    }
 
    /**
     */
    public void setUsername(String uname) {
        this.username = uname;
    }

    /**
     */
private String oldPassword;
private String newPassword;
    public void setPassword(String oldPassword, String newPassword) {
        if (this.oldPassword == this.password) {
        this.password = newPassword;
        }
        else {
        }
        }
    }