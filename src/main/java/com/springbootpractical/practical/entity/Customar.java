package com.springbootpractical.practical.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customar")
@NoArgsConstructor

@TypeDefs({@TypeDef(name = "json",typeClass = JsonType.class)})

public class Customar {
    @Id
    @Column(name = "customar_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int customarId;

    @Column(name = "customar_name",length = 500,nullable = false)
    private String customarName;

    @Column(name = "customar_address",length = 500)
    private  String customarAddress;

    @Column(name = "customar_salary",length = 24)
    private double customarSalary;

    @Type(type = "json")
    @Column(name = "contact_no",columnDefinition = "json")
    private ArrayList contactNo;



    @Column(name = "nic",length = 12,nullable = false)
    private String nic;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean activateStatus;

    @OneToMany(mappedBy="customar")
    private Set<Orders> ordersSet;


    public int getCustomarId() {
        return customarId;
    }

    public void setCustomarId(int customarId) {
        this.customarId = customarId;
    }

    public String getCustomarName() {
        return customarName;
    }

    public void setCustomarName(String customarName) {
        this.customarName = customarName;
    }

    public String getCustomarAddress() {
        return customarAddress;
    }

    public void setCustomarAddress(String customarAddress) {
        this.customarAddress = customarAddress;
    }

    public double getCustomarSalary() {
        return customarSalary;
    }

    public void setCustomarSalary(double customarSalary) {
        this.customarSalary = customarSalary;
    }

    public ArrayList getContactNo() {
        return contactNo;
    }

    public void setContactNo(ArrayList contactNo) {
        this.contactNo = contactNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(boolean activateStatus) {
        this.activateStatus = activateStatus;
    }

    public Customar(int customarId, String customarName, String customarAddress, double customarSalary, ArrayList contactNo, String nic, boolean activateStatus) {
        this.customarId = customarId;
        this.customarName = customarName;
        this.customarAddress = customarAddress;
        this.customarSalary = customarSalary;
        this.contactNo = contactNo;
        this.nic = nic;
        this.activateStatus = activateStatus;
    }

    @Override
    public String toString() {
        return "Customar{" +
                "customarId=" + customarId +
                ", customarName='" + customarName + '\'' +
                ", customarAddress='" + customarAddress + '\'' +
                ", customarSalary=" + customarSalary +
                ", contactNo=" + contactNo +
                ", nic='" + nic + '\'' +
                ", activateStatus=" + activateStatus +
                '}';
    }
}
