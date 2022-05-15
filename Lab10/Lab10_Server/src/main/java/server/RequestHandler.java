package server;

import client.Client;
import client.ClientList;
import message.Message;

public class RequestHandler {

    private static String ERROR = "You need to be logged-in to perform this command!";

    public static String newRequest(ClientSocket clientSocket, String request){
        String response = "Command not recognized!";

        if (getRequest(request).equals("register")){
            response = register(clientSocket, request);
        } else if (getRequest(request).equals("login")) {
            response = login(clientSocket, request);
        } else if (request.equals("exit")){
            response = "Goodbye";
        } else if (request.equals("stop")) {
            response = ERROR;
            if(clientSocket.getLoggedUser() != null){
                response = stop();
            }
        } else if (getRequest(request).equals("friend")) {
            response = ERROR;
            if(clientSocket.getLoggedUser() != null){
                response = friend(clientSocket, request);
            }
        } else if (getRequest(request).equals("send")){
            response = ERROR;
            if(clientSocket.getLoggedUser() != null){
                response = send(clientSocket, request);
            }
        } else if (getRequest(request).equals("read")){
            response = ERROR;
            if(clientSocket.getLoggedUser() != null){
                response = read(clientSocket, request);
            }
        }

        return response;
    }

    private static String getRequest(String request){
        String[] req = request.split(" ");
        return req[0];
    }

    private static String stop(){
        ClientList.save(SocketCreator.PATH);
        SocketCreator.running = false;
        return "Server stopping ...";
    }

    private static String register(ClientSocket clientSocket, String request){
        String[] req = request.split(" ");
        if(ClientList.findByName(req[1]) == null){
            ClientList.addClient(new Client(req[1]));
            ClientList.findByName(req[1]).setLoggedIn(true);
            clientSocket.setLoggedUser(req[1]);
            return "Registered successfully!";
        }
        return "Name already taken!";
    }

    private static String login(ClientSocket clientSocket, String request){
        String[] req = request.split(" ");
        if(clientSocket.getLoggedUser() != null && clientSocket.getLoggedUser().equals(req[1])){
            return "Already logged in";
        }
        if(ClientList.findByName(req[1]) != null){
            if(ClientList.findByName(req[1]).isLoggedIn()){
                return "Account already online!";
            }

            ClientList.findByName(req[1]).setLoggedIn(true);
            if(clientSocket.getLoggedUser() != null){
                ClientList.findByName(clientSocket.getLoggedUser()).setLoggedIn(false);
            }
            clientSocket.setLoggedUser(req[1]);
            return "Welcome";
        }
        if(ClientList.findByName(req[1]) != null){
            ClientList.findByName(req[1]).setLoggedIn(true);
            ClientList.findByName(clientSocket.getLoggedUser()).setLoggedIn(false);
            clientSocket.setLoggedUser(req[1]);
            return "Welcome";
        }
        return "No user found!";
    }

    private static String friend(ClientSocket clientSocket, String request){
        String[] friends = request.split(" ");
        String friended = "";
        Client client = ClientList.findByName(clientSocket.getLoggedUser());
        for(int i = 1; i < friends.length; i++){
            Client friend = ClientList.findByName(friends[i]);
            if(friend != null && !client.isFriend(friend) && !client.getName().equals(friend.getName())){
                friended += friends[i] + ", ";
                client.AddFriend(friend);
                friend.AddFriend(client);
            }
        }

        if(friended.length() > 0){
            friended = friended.substring(0, friended.length() - 2);
            return "You are now friends";
        }
        return "None of the friend requests worked";
    }

    private static String send(ClientSocket clientSocket, String request){
        Client client = ClientList.findByName(clientSocket.getLoggedUser());
        String data = request.substring(5);
        for(Client it : client.getFriends()){
            it.getMessageList().receiveMessage(new Message(client.getName(), data));
        }
        return "Message sent successfully!";
    }

    private static String read(ClientSocket clientSocket, String request){
        boolean readall = true;

        if(!request.equals("read")){
            String[] data = request.split(" ");
            if(data.length > 2)
                readall = Boolean.parseBoolean(data[1]);
        }

        return ClientList.findByName(clientSocket.getLoggedUser()).getMessageList().readMessages();
    }
}
