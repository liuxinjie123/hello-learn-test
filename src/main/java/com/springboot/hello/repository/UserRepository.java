package com.springboot.hello.repository;

import com.springboot.hello.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过 手机号查询user
     * @param mobile
     * @return
     */
    User findByMobile(@Param("mobile") String mobile);

}
