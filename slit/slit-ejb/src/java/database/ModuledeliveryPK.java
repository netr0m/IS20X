/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Morten
 */
@Embeddable
public class ModuledeliveryPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "userID")
    private int userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moduleID")
    private int moduleID;

    public ModuledeliveryPK() {
    }

    public ModuledeliveryPK(int userID, int moduleID) {
        this.userID = userID;
        this.moduleID = moduleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userID;
        hash += (int) moduleID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuledeliveryPK)) {
            return false;
        }
        ModuledeliveryPK other = (ModuledeliveryPK) object;
        if (this.userID != other.userID) {
            return false;
        }
        if (this.moduleID != other.moduleID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.ModuledeliveryPK[ userID=" + userID + ", moduleID=" + moduleID + " ]";
    }
    
}
