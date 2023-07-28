package com.spring.springframework.context;

import java.util.EventListener;

/**
 * @ClassName: ApplicationListener
 * @Description:
 * Interface to be implemented by application event listeners.
 * Based on the standard <code>java.util.EventListener</code> interface
 * for the Observer design pattern.
 * @Author: jay
 **/
public interface ApplicationListener <E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}