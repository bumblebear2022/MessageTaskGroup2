package by.itacademy.jd2.messagetask.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class ActiveUserListener implements HttpSessionAttributeListener {

    private static int quantity = 0;

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
         quantity++;
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        quantity--;
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    public static int getQuantity() {
        return quantity;
    }
}