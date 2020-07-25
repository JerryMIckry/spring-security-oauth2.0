package com.uaa.service.impl;

import com.uaa.entity.PermissionDto;
import com.uaa.entity.UserDto;
import com.uaa.mapper.oauthMapper;
import com.uaa.service.oauthService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Yusentong
 * @Date: 2020/7/23 14:53
 * @Description:
 */
@Service
public class oauthServiceImpl implements oauthService {

    @Resource
    private oauthMapper oauthMapper;

    @Override
    public UserDto getUserByUsername(String username) {
        UserDto userDto = oauthMapper.getUserByUsername(username);
        if (userDto != null) {
            return userDto;
        }
        return null;
    }
    @Override
    public List<String> findPermissionsByUserId(String userId) {
        List<PermissionDto> permissionDtos = oauthMapper.findPermissionsByUserId(userId);
        if (!CollectionUtils.isEmpty(permissionDtos)) {
            List<String> collect = permissionDtos.stream().map(PermissionDto::getCode).collect(Collectors.toList());
            return collect;
        }
        return null;
    }
}
