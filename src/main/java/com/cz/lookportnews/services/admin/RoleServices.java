package com.cz.lookportnews.services.admin;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.entity.admin.Role;
import com.cz.lookportnews.repositories.admin.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServices {

    @Autowired
    RoleRepository roleRepository ;

    public List<Role>  findAllRole() {
        return roleRepository.findAll();
    }

    public Map<String, Object> findPage(Map<String, Object> param) {

        Integer pageSize = ((Integer) param.get("pageSize"));
        Integer pageNumber = (Integer) param.get("pageNumber");

        Pageable pageable = new PageRequest(pageNumber, pageSize);

        Page<Role> page = roleRepository.findAll(pageable);

        Map<String,Object> result = new HashMap<>();
        result.put("total",page.getTotalElements());
        result.put("rows",page.getContent());
        return result;
    }


}
