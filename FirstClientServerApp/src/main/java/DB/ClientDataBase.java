package DB;
import Client.Client;
import lombok.Getter;

public class ClientDataBase {
    @Getter
    private static Client[] clients = {new Client("zelenka", "12345"), new Client("norman", "2554")};

    public static Client getClientByNickName(String name){

        for (int i = 0; i < clients.length; i++) {
            if(clients[i].getNickName().equals(name)){
                return clients[i];
            }
        }
        return null;
    }

}
