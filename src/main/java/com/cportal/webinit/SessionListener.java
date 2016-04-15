package com.cportal.webinit;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class SessionListener implements HttpSessionListener {
@Override
public void sessionCreated(HttpSessionEvent event) {
System.out.println("==== Session is created ====");
event.getSession().setMaxInactiveInterval(10*24*60*60);//seconds//logout after 10 days
}
@Override
public void sessionDestroyed(HttpSessionEvent event) {
System.out.println("==== Session is destroyed ====");
}
}