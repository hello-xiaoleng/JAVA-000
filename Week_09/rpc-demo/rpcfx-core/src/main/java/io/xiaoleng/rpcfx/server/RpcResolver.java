package io.xiaoleng.rpcfx.server;

/**
 * @author chenjia
 * @date 2020/12/15
 */
public interface RpcResolver {

    /**
     * @param serviceClass
     * @return
     */
    Object resolve(String serviceClass);

}
