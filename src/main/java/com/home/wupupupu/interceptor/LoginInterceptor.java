package com.home.wupupupu.interceptor;

import com.home.wupupupu.util.JwtUtil;
import com.home.wupupupu.util.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("Authorization");

        try {
            if(request.getMethod().equals(HttpMethod.OPTIONS.toString())){
                response.setStatus(HttpStatus.NO_CONTENT.value());
                return false;
            }
            ValueOperations<String,String> operations=redisTemplate.opsForValue();
            String redisToken= operations.get(token);
            if (redisToken==null){
                throw new RuntimeException();
            }
            Map<String,Object> map= JwtUtil.parseToken(token);
            ThreadLocalUtil.set(map);

            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
