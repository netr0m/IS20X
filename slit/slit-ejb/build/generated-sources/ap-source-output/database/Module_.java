package database;

import database.Moduledelivery;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T00:31:20")
@StaticMetamodel(Module.class)
public class Module_ { 

    public static volatile SingularAttribute<Module, String> moduleSummary;
    public static volatile SingularAttribute<Module, String> moduleDescription;
    public static volatile ListAttribute<Module, Moduledelivery> moduledeliveryList;
    public static volatile SingularAttribute<Module, String> moduleName;
    public static volatile SingularAttribute<Module, Integer> moduleID;

}