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
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author mortea15
 */
@Entity
@Table(name = "overlook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Overlook.findAll", query = "SELECT o FROM Overlook o"),
    @NamedQuery(name = "Overlook.findByUsername", query = "SELECT o FROM Overlook o WHERE o.username = :username"),
    @NamedQuery(name = "Overlook.findByModuleName", query = "SELECT o FROM Overlook o WHERE o.moduleName = :moduleName"),
    @NamedQuery(name = "Overlook.findByUploadDate", query = "SELECT o FROM Overlook o WHERE o.uploadDate = :uploadDate")})
public class Overlook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "username")
    @Id
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "moduleName")
    private String moduleName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "moduleDelivery")
    private String moduleDelivery;
    @Lob
    @Column(name = "moduleFile")
    private byte[] moduleFile;

    public Overlook() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getModuleDelivery() {
        return moduleDelivery;
    }

    public void setModuleDelivery(String moduleDelivery) {
        this.moduleDelivery = moduleDelivery;
    }

    public byte[] getModuleFile() {
        return moduleFile;
    }

    public void setModuleFile(byte[] moduleFile) {
        this.moduleFile = moduleFile;
    }
    
}
