package io.xiaoleng.rpcfx.demo.provider.rpc;

import io.xiaoleng.rpcfx.api.RpcRequest;
import io.xiaoleng.rpcfx.api.RpcResponse;
import io.xiaoleng.rpcfx.server.RpcInvoker;
import io.xiaoleng.rpcfx.server.RpcResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen jia
 * @date 2020/12/16 17:45
 */

@RestController
public class RpcController {

    @Autowired
    private RpcResolver rpcResolver;


    @PostMapping("/")
    public RpcResponse invoke(@RequestBody RpcRequest rpcRequest) {
        RpcInvoker rpcInvoker = new RpcInvoker(rpcResolver);
        return rpcInvoker.invoke(rpcRequest);
    }
}
