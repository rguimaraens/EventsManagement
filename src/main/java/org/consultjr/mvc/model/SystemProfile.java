/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.consultjr.mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.consultjr.mvc.core.base.ApplicationModel;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "system_profiles")
public class SystemProfile extends ApplicationModel implements Serializable {

    @Id
    @Column(name = "profile_id")
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String shortname;

    private String description;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date updated;

    @OneToMany(mappedBy = "profile", targetEntity = UserSystemProfile.class)
    private List<UserSystemProfile> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public SystemProfile() {
        this.created = new Date();
    }

    public SystemProfile(String shortname, String description) {
        this.created = new Date();
        this.shortname = shortname;
        this.description = description;

    }

    @Override
    public String toString() {
        return "SystemProfile{" + "id=" + id + ", shortname=" + shortname + ", description=" + description + ", created=" + created + ", updated=" + updated + ", users=" + users + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemProfile other = (SystemProfile) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
