package com.uaa.mapper;

import com.uaa.entity.PermissionDto;
import com.uaa.entity.UserDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Yusentong
 * @Date: 2020/7/23 14:55
 * @Description:
 */
@Repository
public interface oauthMapper {

    @Select("select id,username,password,fullname,mobile from t_user where username = #{username} ")
    UserDto getUserByUsername(@Param("username") String username);


    @Select("SELECT * FROM t_permission WHERE id IN" +
            "( SELECT permission_id FROM t_role_permission WHERE role_id IN" +
            "( SELECT role_id FROM t_user_role WHERE user_id = #{id})))")
    List<PermissionDto> findPermissionsByUserId(@Param("id") String id);
}
