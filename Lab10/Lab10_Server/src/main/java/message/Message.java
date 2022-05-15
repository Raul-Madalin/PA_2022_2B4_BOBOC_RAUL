package message;

public class Message {

    private String senderName;
    private String message;
    private boolean isRead;

    public Message(String senderName, String message){
        this.senderName = senderName;
        this.message = message;
        isRead = false;
    }

    @Override
    public String toString() {
        return senderName + ": " + message + " || ";
    }

    public String save(){
        return senderName + ": " + message;
    }

    public boolean getRead() {
        return isRead;
    }

    public void setRead() {
        this.isRead = true;
    }
}
