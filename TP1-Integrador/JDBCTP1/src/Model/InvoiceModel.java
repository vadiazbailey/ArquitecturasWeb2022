package Model;

/**
 * InvoiceModel
 * The invoice model is used to store the invoice information
 * @author vadiazbailey {@Link https://github.com/vadiazbailey}
 * @version 1.0
 */
public class InvoiceModel {
    // Attributes
    private int invoiceId;
    private int clientId;

    /**
     * Constructor
     * @param invoiceId The id of the invoice.
     * @param clientId  The id of the client.
     */
    public InvoiceModel(int invoiceId, int clientId) {
        this.invoiceId = invoiceId;
        this.clientId = clientId;
    }

    /**
     * Get the id of the invoice.
     * @return The id of the invoice.
     */
    public int getInvoiceId() {
        return invoiceId;
    }

    /**
     * Set the id of the invoice.
     * @param invoiceId The id of the invoice.
     */
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    @Override
    /**
     * Get the string representation of the invoice model.
     * @return The string representation of the invoice model.
     */
    public String toString() {
        return "InvoiceModel [clientId=" + clientId + ", invoiceId=" + invoiceId + "]";
    }
}
