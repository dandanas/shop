package com.dandan.mapper;

import com.dandan.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	Integer getUserByUsername(String username);

	User getUserByUserId(Integer userId);

	Integer insertUser(User user);

}
