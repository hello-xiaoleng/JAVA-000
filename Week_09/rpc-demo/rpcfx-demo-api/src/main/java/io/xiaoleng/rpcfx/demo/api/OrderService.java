package io.xiaoleng.rpcfx.demo.api;

/**
 * @author chenjia
 * @date 2020/12/15
 */
public interface OrderService {

    /**
     * 根据订单Id查找订单
     *
     * @param id
     * @return
     */
    Order findOrderById(int id);

}
