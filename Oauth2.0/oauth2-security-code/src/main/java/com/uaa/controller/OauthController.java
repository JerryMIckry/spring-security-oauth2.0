package com.uaa.controller;

import com.uaa.ReponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * ===================================
 * 描 述 : 重写令牌申请接口
 * 包 名 : top.qinxq.single.rest
 * 创建人 : qinxq
 * ===================================
 */
@RestController
@RequestMapping("/oauth")
public class OauthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;


    /*  * =====================================
     * 描   述 : 自定义返回信息添加基本信息
     * 参   数 :  [principal, parameters]
     * 返 回 值 : top.qinxq.single.entity.vo.R
     * =====================================*/


    @PostMapping("/token")
    @ApiOperation("获取oauth2.0token")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "grant_type", required = true, value = "授权类型", defaultValue = "password"),
            @ApiImplicitParam(paramType = "query", name = "client_id", required = true, value = "客户端id", defaultValue = "app-service"),
            @ApiImplicitParam(paramType = "query", name = "client_secret", required = true, value = "客户端秘钥", defaultValue = "app-service"),
            @ApiImplicitParam(paramType = "query", name = "username", required = true, value = "用户名", defaultValue = "app-service"),
            @ApiImplicitParam(paramType = "query", name = "password", required = true, value = "密码", defaultValue = "app-service@2020"),
            @ApiImplicitParam(paramType = "query", name = "scope", required = true, value = "授权范围", defaultValue = "all")
    })
    public ReponseResult postAccessTokenWithUserInfo(Principal principal, @RequestParam(required = true) Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        /*Map<String, Object> data = new LinkedHashMap();
        data.put("accessToken", accessToken.getValue());
        if (accessToken.getRefreshToken() != null) {
            data.put("refreshToken", accessToken.getRefreshToken().getValue());
        }
        return new ReponseResult("认证成功！", data);*/
        return new ReponseResult("认证成功！", accessToken);
    }
}


