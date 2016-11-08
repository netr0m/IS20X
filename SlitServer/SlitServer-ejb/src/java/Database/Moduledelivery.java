/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Svenn
 */
@Entity
@Table(name = "moduledelivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moduledelivery.findAll", query = "SELECT m FROM Moduledelivery m")
    , @NamedQuery(name = "Moduledelivery.findByUserId", query = "SELECT m FROM Moduledelivery m WHERE m.moduledeliveryPK.userId = :userId")
    , @NamedQuery(name = "Moduledelivery.findByModuleId", query = "SELECT m FROM Moduledelivery m WHERE m.moduledeliveryPK.moduleId = :moduleId")
    , @NamedQuery(name = "Moduledelivery.findByUploadDate", query = "SELECT m FROM Moduledelivery m WHERE m.uploadDate = :uploadDate")
    , @NamedQuery(name = "Moduledelivery.findByModuleStatus", query = "SELECT m FROM Moduledelivery m WHERE m.moduleStatus = :moduleStatus")})
public class Moduledelivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModuledeliveryPK moduledeliveryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moduleStatus")
    private boolean moduleStatus;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleDelivery")
    private String moduleDelivery;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleAssesmentComment")
    private String moduleAssesmentComment;
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "moduleId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Module module;

    public Moduledelivery() {
    }

    public Moduledelivery(ModuledeliveryPK moduledeliveryPK) {
        this.moduledeliveryPK = moduledeliveryPK;
    }

    public Moduledelivery(ModuledeliveryPK moduledeliveryPK, Date uploadDate, boolean moduleStatus) {
        this.moduledeliveryPK = moduledeliveryPK;
        this.uploadDate = uploadDate;
        this.moduleStatus = moduleStatus;
    }

    public Moduledelivery(int userId, int moduleId) {
        this.moduledeliveryPK = new ModuledeliveryPK(userId, moduleId);
    }

    public ModuledeliveryPK getModuledeliveryPK() {
        return moduledeliveryPK;
    }

    public void setModuledeliveryPK(ModuledeliveryPK moduledeliveryPK) {
        this.moduledeliveryPK = moduledeliveryPK;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(boolean moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    public String getModuleDelivery() {
        return moduleDelivery;
    }

    public void setModuleDelivery(String moduleDelivery) {
        this.moduleDelivery = moduleDelivery;
    }

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduledeliveryPK != null ? moduledeliveryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moduledelivery)) {
            return false;
        }
        Moduledelivery other = (Moduledelivery) object;
        if ((this.moduledeliveryPK == null && other.moduledeliveryPK != null) || (this.moduledeliveryPK != null && !this.moduledeliveryPK.equals(other.moduledeliveryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Moduledelivery[ moduledeliveryPK=" + moduledeliveryPK + " ]";
    }
    
}
