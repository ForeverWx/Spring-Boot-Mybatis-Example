package com.sm.service.dao;

import com.sm.service.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/* 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类*/
@Mapper
public interface UserDao {
    @Select("select * from d_user where username = #{username}")
    User findUserByName(@Param("username") String name);
}
