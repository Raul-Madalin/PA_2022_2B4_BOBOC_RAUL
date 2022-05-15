package message;

import java.util.ArrayList;
import java.util.List;

public class MessageList {

    private List<Message> messages = new ArrayList<>();

    public void receiveMessage(Message message){
        messages.add(message);
    }

    public String readMessages(){
        String toSend = "";
        for(Message it : messages){
            if(!it.getRead()) {
                toSend += it;
                it.setRead();
            }
        }
        if (toSend.compareTo("") == 0) return "No messages";
        return toSend;
    }

    public List<Message> getMessages(){
        return messages;
    }

}
