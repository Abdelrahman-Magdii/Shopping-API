package com.spring.shopping.usermanagement.Entity;

import com.spring.shopping.base.Entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
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
@Table(name="role")
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity extends BaseEntity<Long> {

    private String name ;

}
