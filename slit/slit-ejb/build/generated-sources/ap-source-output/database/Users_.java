package database;

import database.Moduledelivery;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T23:12:10")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-04T12:08:28")
>>>>>>> origin/mortenv2
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> lName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> fName;
    public static volatile ListAttribute<Users, Moduledelivery> moduledeliveryList;
    public static volatile SingularAttribute<Users, Boolean> isTeacher;
    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}