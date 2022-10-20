package Model;

/**
 * InvoiceProductModel
 * The invoice product model is used to store the invoice product information
 * 
 * @author vadiazbailey {@Link https://github.com/vadiazbailey}
 * @version 1.0
 */
public class InvoiceProductModel {
    // Attributes
    private int invoiceId;
    private int productId;
    private int quantity;

    /**
     * Constructor
     * @param invoiceId The id of the invoice.
     * @param productId The id of the product.
     * @param quantity  The quantity of the product.
     */
    public InvoiceProductModel(int invoiceId, int productId, int quantity) {
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.quantity = quantity;
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
     * Get the id of the product.
     * @return The id of the product.
     */
    public int getProductId() {
        return productId;

    }

    /**
     * Set the id of the product.
     * @param productId The id of the product.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Get the quantity of the product.
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product.
     * @param quantity The quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    /**
     * Get the string representation of the invoice product.
     * @return The string representation of the invoice product.
     */
    public String toString() {
        return "InvoiceProductModel [invoiceId=" + invoiceId + ", productId=" + productId + ", quantity=" + quantity
                + "]";
    }

    
}
