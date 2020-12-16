package io.xiaoleng.rpcfx.demo.provider.rpc;


import io.xiaoleng.rpcfx.server.RpcResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chenjia
 * @date 2020/12/16
 */
@Component
public class CustomRpcResolver implements RpcResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }
}
