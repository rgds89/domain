package com.devsuperior.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();

    public Order(Long id, Instant moment, OrderStatus status, Client client) {
        super();
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public double getTotal(){
        double sum = 0.0;
        for(OrderItem item : items){
            sum += item.getSubTotal();
        }
        return sum;
    }

}
