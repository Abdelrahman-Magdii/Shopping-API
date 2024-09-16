package com.spring.shopping.catalog.Entity;

import com.spring.shopping.base.Entity.BaseEntity;
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
@Table(name="Product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity extends BaseEntity<Long> {

    private String name ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CatalogEntity category;

    private double price;

    private double quantity;

    private String imagePath;

    private String description;
}
