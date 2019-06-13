package com.yakov.Users.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.yakov.Users.bean.User;


public interface IUserDao extends CrudRepository<User, Long>{
	List<User> findByName(String name);
    List<User> findByNameAndPassword(String name, String password);

    @Query("SELECT u FROM User u WHERE u.name=:name and u.password=:password")
    List<User> fetchUsers(@Param("name") String name, @Param("password") String password);

}

    