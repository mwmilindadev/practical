package com.springbootpractical.practical.repository;

import com.springbootpractical.practical.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
