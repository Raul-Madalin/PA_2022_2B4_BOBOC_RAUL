package client;

import message.MessageList;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private boolean loggedIn = false;
    private List<Client> friends = new ArrayList<>();
    private MessageList messageList = new MessageList();

    public Client(String name){
        this.name = name;
    }

    public void AddFriend(Client friend){
        for (Client it : friends){
            if(isFriend(it))
                return;
        }
        if(ClientList.findByName(friend.getName()) != null){
            friends.add(friend);
        }
    }

    public boolean isFriend(Client friend){
        for(Client it : friends){
            if(it.getName().equals(friend.getName()))
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Client> getFriends() {
        return friends;
    }

    public MessageList getMessageList() {
        return messageList;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
