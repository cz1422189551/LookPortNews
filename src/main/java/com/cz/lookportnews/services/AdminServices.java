package com.cz.lookportnews.services;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.entity.admin.Role;
import com.cz.lookportnews.repositories.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Admin authorization(Admin admin , List<Role> roleList ){
        admin.setRoleList(roleList);
        //注意这里是保存操作，主键相同的情况下失效。
        Admin updateAdmin = adminRepository.save(admin);
        return updateAdmin;
    }


}
