package client;

import message.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientList {

    private static List<Client> clients = new ArrayList<>();

    public static void addClient(Client client){
        for(Client it : clients){
            if(it.getName().equals(client.getName()))
                return;
        }
        clients.add(client);
    }

    public static Client findByName(String name){
        for(Client it : clients){
            if(it.getName().equals(name))
                return it;
        }
        return null;
    }

    public static void save(String path){
        try{
            FileWriter writer = new FileWriter(path);
            for(Client it : clients){
                writer.write("Name: " + it.getName() + "\nFriends: ");
                List<Client> friends = it.getFriends();
                for(int i = 0; i < friends.size(); i++){
                    writer.write(friends.get(i).getName());
                    if(i < it.getFriends().size() - 1){
                        writer.write(",");
                    }
                }
                writer.write("\nMessages: ");
                List<Message> messages = it.getMessageList().getMessages();
                for(int i = 0; i < messages.size(); i++){
                    writer.write(messages.get(i).save());
                    if(i < messages.size() - 1){
                        writer.write(", ");
                    }
                }
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void load(String path){
        try{
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String nameLine = reader.nextLine();
                if (!nameLine.isEmpty())
                    nameLine = nameLine.substring(6,nameLine.length());
                if(!reader.hasNextLine())
                    return;
                String friendsLine = reader.nextLine();
                if(!reader.hasNextLine())
                    return;
                String messagesLine = reader.nextLine();

                Client client = findByName(nameLine);
                if(client == null)
                    client = new Client(nameLine);

                if(!friendsLine.equals("Friends: ")){
                    friendsLine = friendsLine.substring(9,friendsLine.length());
                    String[] friends = friendsLine.split(",");
                    for(int i = 0; i < friends.length; i++){
                        Client friend = findByName(friends[i]);
                        if(friend == null){
                            friend = new Client(friends[i]);
                            addClient(friend);
                        }
                        client.AddFriend(friend);
                    }
                }

                if(!messagesLine.equals("Messages: ")){
                    messagesLine = messagesLine.substring(10,messagesLine.length());
                    String[] messages = messagesLine.split(",");
                    for(int i = 0; i < messages.length; i++){
                        String[] data = messages[i].split(":");
                        Message message = new Message(data[0], data[1]);
                        client.getMessageList().receiveMessage(message);
                    }
                }

                addClient(client);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

}
