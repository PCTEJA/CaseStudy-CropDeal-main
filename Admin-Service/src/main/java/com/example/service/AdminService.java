package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.models.Admin;



@Service
@Component
public interface AdminService {
	
	public List<Admin> findAll();
    public Optional<Admin> getAdminById(String id);
    public Admin addAdmin(Admin admin);
    public Admin updateAdmin(Admin admin); 
    public String deleteById(String adminId);

}
