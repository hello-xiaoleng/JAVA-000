package com.xiaoleng.datasource02.config;

/**
 * @author chenjia
 */
public class HandlerDataSource {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 提供给AOP去设置当前的线程的数据源的信息
     */
    public static void setDataSource(String datasource) {
        threadLocal.set(datasource);
    }

    /**
     * 提供给AbstractRoutingDataSource的实现类，通过key选择数据源
     */
    public static String getDataSource() {
        return threadLocal.get();
    }

    /**
     * 清楚数据源
     */
    public static void clear() {
        threadLocal.remove();
    }


}
