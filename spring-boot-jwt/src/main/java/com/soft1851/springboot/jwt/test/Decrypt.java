package com.soft1851.springboot.jwt.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @ClassName Decrypt
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Decrypt {
    /**
     * 先验证token是否被伪造，然后解码token。
     *
     * @param token 字符串token
     * @return 解密后的DecodedJWT对象，可以读取token中的数据。
     */


    public DecodedJWT deToken(final String token, byte[] secretKey) {
        DecodedJWT jwt = null;
        try {
            // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥。
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return jwt;
    }
}
