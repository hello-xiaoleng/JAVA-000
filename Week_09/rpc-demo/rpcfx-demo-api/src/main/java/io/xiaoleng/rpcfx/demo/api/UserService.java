package io.xiaoleng.rpcfx.demo.api;

/**
 * @author chenjia
 * @date 2020/12/15
 */
public interface UserService {

    /**
     * 通过用户Id查找用户
     *
     * @param id
     * @return
     */
    User findById(int id);

}
