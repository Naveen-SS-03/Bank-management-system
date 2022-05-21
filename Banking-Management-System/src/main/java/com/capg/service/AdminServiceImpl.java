package com.capg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Admin;
import com.capg.exceptions.AdminFoundException;
import com.capg.exceptions.AdminNotFoundException;
import com.capg.repository.AdminRepository;

@Service
public class AdminServiceImpl {
	@Autowired
	private AdminRepository adminrepo;

	public Admin addAdmin(Admin admin) {
		Admin obj = adminrepo.findByAdminUsername(admin.getAdminUsername());
		if(obj != null)
			throw new AdminFoundException("Admin already created");
		return adminrepo.save(admin);
	}

	public boolean validateAdmin(String username, String password) {
		Optional<Admin> admin = adminrepo.findByAdminUsernameAndAdminpassword(username, password);
		if(admin.get() == null)
			throw new AdminNotFoundException("Admin not created");
		else
			return true;
	}

	public Optional<Admin> viewByAdminUserName(String username, String password) {
		Optional<Admin> admin = adminrepo.findByAdminUsernameAndAdminpassword(username, password);
		if(admin.get() == null)
			throw new AdminNotFoundException("Admin not created");
		return admin;		
	}
}
