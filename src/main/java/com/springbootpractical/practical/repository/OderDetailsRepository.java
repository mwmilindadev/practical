package com.springbootpractical.practical.repository;

import com.springbootpractical.practical.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
