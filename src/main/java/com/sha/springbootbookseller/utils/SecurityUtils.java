package com.sha.springbootbookseller.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

public class SecurityUtils {
    public static final String ROLE_PREFIX="ROLE_";
    public static final String AUTH_HEADER="authorization";
    public static final String AUTH_TOKEN_TYPE="Bearer";
    public static final String AUTH_TOKEN_PREFIX= AUTH_TOKEN_TYPE + " ";


    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole= role.startsWith(ROLE_PREFIX)? role: ROLE_PREFIX+role;
        return new SimpleGrantedAuthority(formattedRole);
    }

    public static String extractAuthTokenFromRequest(HttpServletRequest request){
        String baererToken=request.getHeader(AUTH_HEADER);

        if(StringUtils.hasLength(baererToken) && baererToken.startsWith(AUTH_TOKEN_PREFIX)){
            return baererToken.substring(7);
        }
        return null;
    }

}