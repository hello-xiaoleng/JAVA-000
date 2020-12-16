package io.xiaoleng.rpcfx.demo.consumer;

import io.xiaoleng.rpcfx.client.JdkRpcClient;
import io.xiaoleng.rpcfx.client.RpcClient;
import io.xiaoleng.rpcfx.demo.api.UserService;

/**
 * @author chenjia
 * @date 2020/12/15
 */
public class RpcClientApplication {

    public static void main(String[] args) {
        RpcClient rpcClient = new JdkRpcClient();
        UserService userService = rpcClient.create(UserService.class, "http://localhost:8080/");
        userService.findById(1);
    }

}
