package com.example.adminservice.repository;

import com.example.adminservice.pojo.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    @Query(value = "{'username': '?0'}")
    public Admin getAdminByUsername(String name);
}
