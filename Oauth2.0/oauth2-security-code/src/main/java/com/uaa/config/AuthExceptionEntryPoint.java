package com.uaa.config;

import com.google.common.collect.Maps;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author : Yusentong
 * @Date: 2020/7/23 15:28
 * @Description:
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Map map = Maps.newHashMap();
        map.put("code", "401");
        map.put("message", authException.getMessage());
        map.put("content", "");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
