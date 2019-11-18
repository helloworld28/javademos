package com.popwerjun.spring;

/**
 * @author Jim
 * @date 2019/6/20
 */
public class DefaultServiceLocator {

    private ClientService clientService = new ClientServiceImpl();

    public ClientService createClientService() {
        return clientService;
    }
}
