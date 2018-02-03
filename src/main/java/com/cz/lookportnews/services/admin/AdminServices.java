package com.cz.lookportnews.services.admin;

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

    public Admin findOne (String adminName) {
        return adminRepository.findOne(adminName);
    }

}
