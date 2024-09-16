package com.spring.shopping.order.Entity;

import com.spring.shopping.base.Entity.BaseEntity;
import com.spring.shopping.catalog.Entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableJpaAuditing
@Entity
@Table(name="order_details")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetails extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

   private double quantity;

   private double price;

}
