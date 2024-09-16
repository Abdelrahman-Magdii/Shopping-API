package com.spring.shopping.order.Repo;

import com.spring.shopping.base.Repo.BaseRepo;
import com.spring.shopping.order.Entity.OrderDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends BaseRepo<OrderDetails,Long> {


}
