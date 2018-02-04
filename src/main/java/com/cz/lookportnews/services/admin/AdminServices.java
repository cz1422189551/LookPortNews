package com.cz.lookportnews.services.admin;

import com.cz.lookportnews.entity.User;
import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.entity.admin.Role;
import com.cz.lookportnews.repositories.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServices {

    @Autowired
    AdminRepository adminRepository;

    /**
     * 登陆验证
     * @param admin
     * @return
     */
    public Admin validateAdmin(Admin admin) {

        return adminRepository.validateAdmin(
                admin.getAdminName(),
                admin.getPassword()
        );
    }

    /**
     *  为admin 管理员 授权
     * @return
     */
    @Transactional
    public Integer authorization(Admin admin , List<Role> roleList ) {
        Integer integer = adminRepository.authorization
                (
                admin.getAdminName(),
                roleList
                );
        if(integer>0){
            System.out.println("授权（更新）成功");
        } else {
            System.out.println("授权（更新) 失败");
        }
        return integer;
    }

    /**
     *  为admin 管理员 授权
     * @return
     */
    @Transactional
    public Admin authorizationSave(Admin admin , List<Role> roleList ) {
        admin.setRoleList(roleList);
        Admin save = adminRepository.save(admin);
        return save;
    }


    public List<Admin> findPage(){
        return adminRepository.findAll();
    }

    public Admin findOne (String adminName) {
        return adminRepository.findOne(adminName);
    }


    public Map<String, Object> findPage(Map<String, Object> param) {

        Integer pageSize = ((Integer) param.get("pageSize"));
        Integer pageNumber = (Integer) param.get("pageNumber");
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "creatime");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        Page<Admin> page = adminRepository.findAll(pageable);

        Map<String,Object> result = new HashMap<>();
        result.put("total",page.getTotalElements());
        result.put("rows",page.getContent());
        return result;
    }
}
