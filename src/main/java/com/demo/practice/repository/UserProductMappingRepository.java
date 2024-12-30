package com.demo.practice.repository;

import com.demo.practice.entity.UserProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductMappingRepository extends JpaRepository<UserProductMapping, String> {
    List<UserProductMapping> findByUserId(String userId);
}
