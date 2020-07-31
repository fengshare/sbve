package com.xf.web.common.jwt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.github.pagehelper.util.StringUtil;
import com.xf.web.common.exception.BaseException;
import com.xf.web.common.redisUtils.RedisUtil;
import com.xf.web.common.result.RestCode;
import com.xf.web.common.result.ResultCode;
import com.xf.web.common.utils.FastJsonUtil;
import com.xf.web.entity.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    public static final String USER_TOKEN_FOUND = "USER_TOKEN_FOUND_";

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 存储 用户名 和 密码 生成 token
     */
    public String getToken(UmsAdmin umsAdmin) {
        String token = "";
        token = JWT.create().withAudience(umsAdmin.getUsername())
                .sign(
                        Algorithm.HMAC512(umsAdmin.getPassword())
                );
        return token;
    }

    //    eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJOMDIwNTAifQ.Bo7EEz7_7d0oJz3NUEPMfymMKTpHWMT96NLKHIPZUKhvVDYaeOFCl4XiIMEdSzg69MLv5PR0-ERHj0ixFve3EQ
    public String parseToken(String token) {
        try {
            String username = JWT.decode(token).getAudience().get(0);
            return username;
        } catch (JWTDecodeException j) {
            return null;
        }
    }


    /**
     * 根据token取出用户
     */
    public UmsAdmin getUserByToken(String token) {
        // 执行认证
        if (StringUtil.isEmpty(token)) {
            throw new BaseException(RestCode.AUTH_INVALID, "无token，请重新登录");
        }
        // 获取 token 中的 userName
        String userName;
        try {
            userName = parseToken(token);
        } catch (JWTDecodeException j) {
            throw new BaseException(RestCode.AUTH_INVALID, "token解析错误，请重新登录");
        }
        UmsAdmin umsAdmin = getUserByUsername(userName);
        if (umsAdmin == null) {
            throw new BaseException(RestCode.AUTH_INVALID, "用户不存在，请重新登录");
        }
        return umsAdmin;
    }


    public UmsAdmin getUserByUsername(String userName) {
        String str = (String) redisUtil.get(TokenUtil.USER_TOKEN_FOUND + userName);
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        UmsAdmin umsAdmin = FastJsonUtil.jsonToObject(str, UmsAdmin.class);
        return umsAdmin;
    }

}
