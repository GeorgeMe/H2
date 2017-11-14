package com.h2.common.web;

import com.github.pig.common.constant.CommonConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/28
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;

    /**
     * 根据请求heard中的token获取用户
     *
     * @return 用户名
     */
    public String getUser() {
        String authorization = request.getHeader(CommonConstant.REQ_HEADER);
        String token = StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
        String key = Base64.getEncoder().encodeToString(CommonConstant.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims.get("user_name").toString();
    }

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        String authorization = request.getHeader(CommonConstant.REQ_HEADER);
        String token = StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT);
        String key = Base64.getEncoder().encodeToString(CommonConstant.SIGN_KEY.getBytes());
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        List<String> roleNames = (List<String>) claims.get("authorities");
        return roleNames;
    }
}
