package Client;


import lombok.Data;

@Data
public class Client {
    private String nickName;
    private String passwd;
    private boolean isOnline = false;

    public Client(String nickName, String passwd){
        this.nickName = nickName;
        this.passwd = passwd;
    }

    public void setOnline(){
        isOnline = true;
    }

    public void setOffline(){
        isOnline = false;
    }

    public boolean isOnline(){
        return isOnline;
    }
}
