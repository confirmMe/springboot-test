package com.ysw.demojpa.repository;

import com.ysw.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Integer> {
    //第一个泛型是被操作的POJO类，第二个泛型是主键的类型
}
