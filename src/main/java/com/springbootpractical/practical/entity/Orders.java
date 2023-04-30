package com.springbootpractical.practical.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@TypeDefs(@TypeDef(name="json",typeClass = JsonType.class))
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customar_id", nullable=false)
    private Customar customar;


    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total", nullable = false)
    private Double total;


    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetailsSet;

    public Orders(Customar customar, Date date, Double total) {
        this.customar = customar;
        this.date = date;
        this.total = total;
    }


}
