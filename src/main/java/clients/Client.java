package clients;

/**
 * Created by Livius on 5/27/2017.
 */
import javax.persistence.*;

/**
 * Created by shakeelosmani on 24/12/16.
 */

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long clientId;

    public String clientName;

    public int clientOrders;

    public Long getclientId() {
        return clientId;
    }

    public void setclientId(Long clientId) {
        clientId = clientId;
    }

    public String getclientName() {
        return clientName;
    }

    public void setclientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientOrders() {
        return clientOrders;
    }

    public void setClientOrders(int clientOrders) {
        this.clientOrders = clientOrders;
    }

}