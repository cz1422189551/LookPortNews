package com.cz.lookportnews.repositories.admin;

import com.cz.lookportnews.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin,String> {

    @Query(
            value = "select a from Admin a where a.adminName=:adminName and a.password=:password")
     Admin validateAdmin(
            @Param("adminName") String adminName
            , @Param("password") String password
    ) ;

}
