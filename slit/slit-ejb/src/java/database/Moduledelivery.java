/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author InWhi
 */
@Entity
@Table(name = "moduledelivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moduledelivery.findAll", query = "SELECT m FROM Moduledelivery m"),
    @NamedQuery(name = "Moduledelivery.findByDeliveryID", query = "SELECT m FROM Moduledelivery m WHERE m.deliveryID = :deliveryID"),
    @NamedQuery(name = "Moduledelivery.findByUploadDate", query = "SELECT m FROM Moduledelivery m WHERE m.uploadDate = :uploadDate"),
    @NamedQuery(name = "Moduledelivery.findByModuleStatus", query = "SELECT m FROM Moduledelivery m WHERE m.moduleStatus = :moduleStatus"),
    @NamedQuery(name = "Moduledelivery.findByModuleFile", query = "SELECT m FROM Moduledelivery m WHERE m.moduleFile = :moduleFile")})
public class Moduledelivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deliveryID")
    private Integer deliveryID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moduleStatus")
    private int moduleStatus;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleDelivery")
    private String moduleDelivery;
    @Size(max = 300)
    @Column(name = "moduleFile")
    private String moduleFile;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleAssesmentComment")
    private String moduleAssesmentComment;
    @JoinColumn(name = "moduleID", referencedColumnName = "moduleID")
    @ManyToOne
    private Module moduleID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private Users userID;

    public Moduledelivery() {
    }

    public Moduledelivery(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Moduledelivery(Integer deliveryID, Date uploadDate, int moduleStatus) {
        this.deliveryID = deliveryID;
        this.uploadDate = uploadDate;
        this.moduleStatus = moduleStatus;
    }

    public Integer getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(int moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    public String getModuleDelivery() {
        return moduleDelivery;
    }

    public void setModuleDelivery(String moduleDelivery) {
        this.moduleDelivery = moduleDelivery;
    }

    public String getModuleFile() {
        return moduleFile;
    }

    public void setModuleFile(String moduleFile) {
        this.moduleFile = moduleFile;
    }

    public String getModuleAssesmentComment() {
        return moduleAssesmentComment;
    }

    public void setModuleAssesmentComment(String moduleAssesmentComment) {
        this.moduleAssesmentComment = moduleAssesmentComment;
    }

    public Module getModuleID() {
        return moduleID;
    }

    public void setModuleID(Module moduleID) {
        this.moduleID = moduleID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryID != null ? deliveryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moduledelivery)) {
            return false;
        }
        Moduledelivery other = (Moduledelivery) object;
        if ((this.deliveryID == null && other.deliveryID != null) || (this.deliveryID != null && !this.deliveryID.equals(other.deliveryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Moduledelivery[ deliveryID=" + deliveryID + " ]";
    }
    
}
