package top.pi1grim.mall.interceptor;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.pi1grim.mall.type.TokenStatus;
import top.pi1grim.mall.util.JwtUtil;
import top.pi1grim.mall.vo.VO;

import java.io.IOException;


@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //跳过OPTIONS
        if("OPTIONS".equals(request.getMethod()))return true;
        //校验Token
        String token = request.getHeader("token");
        try {
            if (token == null)throw new JwtException("Token为空");
            Jwts.parserBuilder()
                    .setSigningKey(JwtUtil.KEY)
                    .build()
                    .parseClaimsJws(token);
            //通过了
            return true;
        } catch (JwtException e) {
            response.setContentType("application/json;charset=utf-8");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("interceptor", VO.getRetVOByCode(10, "该请求已被拦截，请检查Token", TokenStatus.class));
            response.getWriter().print(jsonObject);
        }
        return false;
    }
}
