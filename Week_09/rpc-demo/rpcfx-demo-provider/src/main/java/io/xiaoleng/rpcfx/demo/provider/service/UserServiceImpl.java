package io.xiaoleng.rpcfx.demo.provider.service;

import io.xiaoleng.rpcfx.demo.api.User;
import io.xiaoleng.rpcfx.demo.api.UserService;
import org.springframework.stereotype.Service;

/**
 * @author chenjia
 * @date 2020/12/16
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "user" + System.currentTimeMillis());
    }
}
