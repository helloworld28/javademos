package com.popwerjun.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * Created by Administrator on 2019/7/2.
 */
public class BeanInitializationBeanProcessor implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(BeanInitializationBeanProcessor.class);

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("before bean[{}] initalization ...........", beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("after bean[{}] initalization ...........", beanName);

        return bean;
    }
}
