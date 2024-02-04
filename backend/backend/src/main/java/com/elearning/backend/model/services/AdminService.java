package com.elearning.backend.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.backend.model.dal.entities.Admin;
import com.elearning.backend.model.dal.entities.UserRole;
import com.elearning.backend.model.dal.entities.Enumerated.UserRoleEnum;
import com.elearning.backend.model.dal.repositories.AdminRepository;
import com.elearning.backend.model.dal.repositories.UserRoleRepository;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public Admin addAdmin(Admin admin) {
        UserRole adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN)
                .orElseThrow(() -> new RuntimeException("Admin role not found"));
        admin.setRole(adminRole);
        return adminRepository.save(admin);
    }

    public String deleteAdmin(String username) {
        Admin admin = adminRepository.getAdminByUsername(username);
        if (admin != null) {
            adminRepository.delete(admin);
            return "admin " + username + " deleted successfully!";
        } else {
            return "admin with this username not found!";
        }
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdmin(String username) {
        return adminRepository.getAdminByUsername(username);
    }

    public Admin updateAdmin(String Username, Admin newAdmin) {
        Admin olAdmin = adminRepository.getAdminByUsername(Username);
        olAdmin.setUsername(newAdmin.getUsername());
        olAdmin.setPassword(newAdmin.getPassword());
        return adminRepository.save(olAdmin);
    }

    public List<Admin> search(String searched) {
        return adminRepository.search(searched);
    }
}
