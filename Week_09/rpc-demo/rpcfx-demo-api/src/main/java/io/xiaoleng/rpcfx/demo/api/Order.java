package io.xiaoleng.rpcfx.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenjia
 * @date 2020/12/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int id;

    private String name;

    private float amount;
}
