package com.uaa.service;

import com.uaa.entity.UserDto;

import java.util.List;

/**
 * @author : Yusentong
 * @Date: 2020/7/23 14:51
 * @Description:
 */
public interface oauthService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    UserDto getUserByUsername(String username);

    /**
     * 根据用户的id查询用户的权限
     *
     * @param userId
     * @return
     */
    List<String> findPermissionsByUserId(String userId);
}
