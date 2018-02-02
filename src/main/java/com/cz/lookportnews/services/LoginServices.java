package com.cz.lookportnews.services;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.repositories.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices implements ILoginServcies<Admin> {

    @Autowired
    private AdminRepository adminRepository ;



//    public Admin  validateAdmin(Admin admin) {
//        Admin ad =  adminRepository.findOne()
//    }

    @Override
    public Admin login(Admin admin) {
        return null;
    }
}
