package edu.harrisburgu.cisc525.app;

import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingImpl extends UnicastRemoteObject implements Greeting {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingImpl.class);
    private static final long serialVersionUID = 3471960281840894899L;

    public GreetingImpl() throws RemoteException {
        super();
        LOGGER.info("Constructing ...");
    }

    @Override
    public String hello(String name) throws RemoteException, UnknownHostException {
        String greetings = new Greetings().hello(name);
        LOGGER.info("Receiving call with name {}", name);
        LOGGER.info("Returning greetings with {}", greetings);
        return greetings;
    }

    @Override
    public Message hello(Message message) throws RemoteException, UnknownHostException {
        Greetings greetings = new Greetings();
        LOGGER.info("Receiving call with name {}", message.getName());
        Message retMessage = greetings.hello(message);
        LOGGER.info("Returning greetings with {}", getMessageInJson(retMessage));
        return retMessage;
    }

    private String getMessageInJson(Message message) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(message);
        } catch(JsonProcessingException e){
            return "*** Empty ***";
        }
    }
    
}
