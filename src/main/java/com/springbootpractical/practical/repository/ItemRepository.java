package com.springbootpractical.practical.repository;

import com.springbootpractical.practical.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findAllByBalanceQuantityEquals(double balanceQty);
}
