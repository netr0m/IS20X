package database;

import database.Module;
import database.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T00:31:20")
@StaticMetamodel(Moduledelivery.class)
public class Moduledelivery_ { 

    public static volatile SingularAttribute<Moduledelivery, Integer> deliveryID;
    public static volatile SingularAttribute<Moduledelivery, String> moduleAssesmentComment;
    public static volatile SingularAttribute<Moduledelivery, String> moduleDelivery;
    public static volatile SingularAttribute<Moduledelivery, String> moduleFile;
    public static volatile SingularAttribute<Moduledelivery, Date> uploadDate;
    public static volatile SingularAttribute<Moduledelivery, Integer> moduleStatus;
    public static volatile SingularAttribute<Moduledelivery, Module> moduleID;
    public static volatile SingularAttribute<Moduledelivery, Users> userID;

}