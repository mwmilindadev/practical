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

@Entity
@Table(name = "customar")
@NoArgsConstructor
@AllArgsConstructor
@Data

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






}
