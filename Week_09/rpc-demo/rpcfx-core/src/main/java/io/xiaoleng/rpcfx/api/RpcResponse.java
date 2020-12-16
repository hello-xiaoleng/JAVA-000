package io.xiaoleng.rpcfx.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenjia
 * @date 2020/12/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RpcResponse {

    private Object result;

    private boolean status;

    private Exception exception;
}
