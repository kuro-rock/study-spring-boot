package com.example.sample.mapper;

import com.example.sample.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    User findUserByEmail(String email);
}
