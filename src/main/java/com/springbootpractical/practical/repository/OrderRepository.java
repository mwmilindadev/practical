package com.springbootpractical.practical.repository;

import com.springbootpractical.practical.dto.queryinterface.OrderDetailsInterface;
import com.springbootpractical.practical.entity.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "select a.customar_name as customarName,a.customar_address as customarAddress," +
            " a.contact_no as contactNo, b.order_date as date,b.total as total" +
            " from customar a,orders b where a.customar_id=b.customar_id and active_status=?1 ",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean satus, Pageable pageable);

    @Query(value = "select count(*) from  customar a,orders b where a.customar_id=b.customar_id and active_status=?1",nativeQuery = true)

    long countAllDetails(boolean satus);
}
