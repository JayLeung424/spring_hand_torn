package com.spring.springframework.context;

import java.util.EventObject;


/**
 * @ClassName: ApplicationContext
 * @Description:
 * Class to be extended by all application events. Abstract as it
 * doesn't make sense for generic events to be published directly.
 * @Author: jay
 **/
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}