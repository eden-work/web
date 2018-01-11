package com.wrox.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(this.date() + ": Session " + httpSessionEvent.getSession().getId() + " created.");
        SessionRegistry.addSession(httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(this.date() + ": Session " + httpSessionEvent.getSession().getId() +
                " destroyed.");
        SessionRegistry.removeSession(httpSessionEvent.getSession());
    }

    @Override
    public void sessionIdChanged(HttpSessionEvent httpSessionEvent, String oldSessionId) {
        System.out.println(this.date() + ": Session ID " + oldSessionId +
                " changed to " + httpSessionEvent.getSession().getId());
        SessionRegistry.updateSessionId(httpSessionEvent.getSession(), oldSessionId);

    }

    private String date () {
        return this.sdf.format(new Date());
    }
}
