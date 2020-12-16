package io.xiaoleng.rpcfx.demo.provider.service;

import io.xiaoleng.rpcfx.demo.api.Order;
import io.xiaoleng.rpcfx.demo.api.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author chenjia
 * @date 2020/12/16
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "order" + System.currentTimeMillis(), 9.9f);
    }
}
