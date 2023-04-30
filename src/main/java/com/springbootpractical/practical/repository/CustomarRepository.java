package com.springbootpractical.practical.repository;

import com.springbootpractical.practical.entity.Customar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomarRepository extends JpaRepository<Customar,Integer> {
    List<Customar> findAllByCustomarAddressEqualsAndCustomarNameEquals(String cityName, String customarName);

    Page<Customar> findAllByActivateStatusEquals(boolean status, Pageable pageable);

    long countAllByActivateStatusEquals(boolean status);
}
