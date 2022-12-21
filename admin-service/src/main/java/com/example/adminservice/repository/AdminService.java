package com.example.adminservice.repository;

import com.example.adminservice.pojo.Admin;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @RabbitListener(queues = "GetAdminQueue")
    public Admin GetAdminByUsername(String n){
        return adminRepository.getAdminByUsername(n);
    }

}
