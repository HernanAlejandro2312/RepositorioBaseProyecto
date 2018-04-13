/**
 * @author: edson
 */

package com.dh.spring5webapp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBeanLifeCycleDemo) {
            ((SpringBeanLifeCycleDemo) bean).beforeInit();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBeanLifeCycleDemo) {
            ((SpringBeanLifeCycleDemo) bean).afterInit();
        }
        return bean;
    }
}