package io.xiaoleng.rpcfx.client;

/**
 * @author chen jia
 * @date 2020/12/16 11:11
 */
public interface RpcClient {

    /**
     * 创建rpc请求
     *
     * @param serviceClass
     * @param url
     * @param <T>
     * @return
     */
    <T> T create(final Class<T> serviceClass, final String url);


}
