package edu.harrisburgu.cisc525.app;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Greetings class
 * 
 */
public class Greetings {
    public String hello(String name) throws UnknownHostException {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "MacBook-Air.local";
        }

        return String.format(
            "%s from %s/%s",
            name, hostname, ManagementFactory.getRuntimeMXBean().getName()
        );
   }

   public Message hello(Message message) {
       return message;
   }
}
