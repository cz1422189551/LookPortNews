package com.cz.lookportnews.services.admin;

import com.cz.lookportnews.entity.admin.Role;
import com.cz.lookportnews.repositories.admin.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {

    @Autowired
    RoleRepository roleRepository ;

    public List<Role>  findAllRole() {
        return roleRepository.findAll();
    }


}
