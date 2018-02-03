package com.cz.lookportnews.repositories.admin;

import com.cz.lookportnews.entity.admin.Admin;
import com.cz.lookportnews.entity.admin.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,String> {

    /**
     *  登陆验证
     * @param adminName 账号
     * @param password 密码
     * @return 查询到的记录
     */
    @Query(
            value = "select a from Admin a where a.adminName=:adminName and a.password=:password"
    )

     Admin validateAdmin(
            @Param("adminName") String adminName
            , @Param("password") String password
    ) ;

    /**
     *  为管理员授权
     * @param adminName
     * @param roleList
     * @return
     */
    @Modifying(clearAutomatically=true)
    @Query(
            value="update Admin a set a.roleList =:roleList where a.adminName=:adminName"
    )
    Integer authorization(
            @Param("adminName") String adminName , @Param("roleList")  List<Role> roleList);


}
