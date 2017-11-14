package com.h2.auth.feign.fallback;

import com.h2.auth.feign.UserService;
import com.h2.common.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lengleng
 * @date 2017/10/31
 * 用户服务的fallback
 */
public class UserServiceFallbackImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserVo findUserByUsername(String username) {
        logger.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }
}
