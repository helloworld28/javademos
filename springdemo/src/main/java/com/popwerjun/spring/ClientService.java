package com.popwerjun.spring;

/**
 * @author Jim
 * @date 2019/6/20
 */
public interface ClientService {


    static ClientService createInstance() {
        return new ClientServiceImpl();
    }

    void foo();

}
