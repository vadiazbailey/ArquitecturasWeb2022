package Model;

/**
 * ClientModel
 * The client model is used to store the client information
 * @author vadiazbailey {@Link  https://github.com/vadiazbailey}
 * @version 1.0
 */
public class ClientModel {
    //Attributes
    private int clientId;
    private String clientName;
    private String clientEmail;

    /**
     * Constructor
     * @param clientId The id of the client.
     * @param clientName The name of the client.
     * @param clientEmail The Email of the client.
     */
    public ClientModel(int clientId, String clientName, String clientEmail) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    /**
     * Get the id of the client.
     * @return The id of the client.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Set the id of the client.
     * @param clientId The id of the client.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Get the name of the client.
     * @return The name of the client.
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Set the name of the client.
     * @param clientName The name of the client.
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Get the Email of the client.
     * @return The Email of the client.
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * Set the Email of the client.
     * @param clientEmail The Email of the client.
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    /**
     * toString
     * @return The client information.
     */
    public String toString() {
        return "ClientModel [clientEmail=" + clientEmail + ", clientId=" + clientId + ", clientName=" + clientName
                + "]";
    }

}
