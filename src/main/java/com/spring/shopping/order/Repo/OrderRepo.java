package com.spring.shopping.order.Repo;

import com.spring.shopping.base.Repo.BaseRepo;
import com.spring.shopping.order.Entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends BaseRepo<Order,Long> {


}
