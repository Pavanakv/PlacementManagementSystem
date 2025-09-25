package com.example.PlacementManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacementManagement.Entity.Admin;
import com.example.PlacementManagement.Repository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo arepo;

    // CREATE - Add new admin
    public Admin addAdmin(Admin a) {
        return arepo.save(a);
    }

    // READ - Get all admins
    public List<Admin> getAdmin() {
        return arepo.findAll();
    }

    // READ - Get admin by ID
    public Admin getAdminById(Long id) {
        Optional<Admin> admin = arepo.findById(id);
        return admin.orElse(null);
    }

    // UPDATE - Update admin details
    public Admin updateAdmin(Admin a) {
        Optional<Admin> existingAdmin = arepo.findById(a.getId());
        if (existingAdmin.isPresent()) {
            Admin adminToUpdate = existingAdmin.get();
            adminToUpdate.setName(a.getName());
            adminToUpdate.setPassword(a.getPassword());
            // update other fields if needed
            return arepo.save(adminToUpdate);
        } else {
            return null;
        }
    }

    // DELETE - Delete admin by ID
    public void deleteAdmin(Long id) {
        arepo.deleteById(id);
    }

    // Check if admin exists
    public boolean existsById(Long id) {
        return arepo.existsById(id);
    }
}