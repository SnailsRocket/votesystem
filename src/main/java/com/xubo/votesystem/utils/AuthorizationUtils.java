package com.xubo.votesystem.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

/**
 * @Author xubo
 * @Date 2022/5/10 14:17
 */
public class AuthorizationUtils {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationUtils.class);

    public static Map<String, Object> getRequestUser() {
        try {
//            Map<String, Object> principal = (Map<String, Object>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            Map<String, Object> principal = (Map<String, Object>) authentication.getPrincipal();
            return principal;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            throw new RuntimeException("获取当前用户信息失败！");
        }
    }


}
