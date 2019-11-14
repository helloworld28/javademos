package com.popwerjun.spring;

import org.springframework.context.ApplicationContext;

/**
 * Created by Administrator on 2019/6/27.
 */
public abstract class CommandManager {

    private ApplicationContext applicationContext;

    public void process() {
        Command command = createCommand();
        command.execute();
    }

    public abstract Command createCommand();


}
