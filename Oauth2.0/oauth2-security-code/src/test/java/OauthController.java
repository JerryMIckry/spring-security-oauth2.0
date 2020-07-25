import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
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

   /* @Autowired
    private TokenEndpoint tokenEndpoint;

    *//**
     * =====================================
     * 描   述 : 自定义返回信息添加基本信息
     * 参   数 :  [principal, parameters]
     * 返 回 值 : top.qinxq.single.entity.vo.R
     * =====================================
     *//*
    @PostMapping("/token")
    public ReponseResult postAccessTokenWithUserInfo(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Map<String, Object> data = new LinkedHashMap();
        data.put("accessToken", accessToken.getValue());
        if (accessToken.getRefreshToken() != null) {
            data.put("refreshToken", accessToken.getRefreshToken().getValue());
        }
        return new ReponseResult("认证成功！", data);
    }*/
}


