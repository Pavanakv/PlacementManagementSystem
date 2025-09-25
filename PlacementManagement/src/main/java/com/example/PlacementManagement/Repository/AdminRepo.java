package com.example.PlacementManagement.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PlacementManagement.Entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
}
