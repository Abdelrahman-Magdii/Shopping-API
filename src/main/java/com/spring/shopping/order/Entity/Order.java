package com.spring.shopping.order.Entity;

import com.spring.shopping.base.Entity.BaseEntity;
import com.spring.shopping.usermanagement.Entity.AppUserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableJpaAuditing
@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity<Long> {

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUserEntity user;


}
