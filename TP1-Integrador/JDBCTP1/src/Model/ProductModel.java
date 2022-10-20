package Model;

/**
 * InvoiceProduct
 * The invoice product model is used to store the invoice product information
 * @author vadiazbailey {@Link https://github.com/vadiazbailey}
 * @version 1.0
 */
public class ProductModel {
    // Attributes
    private int productId;
    private String name;
    private Float value;

    /**
     * Constructor
     * @param productId The id of the product.
     * @param name      The name of the product.
     * @param value     The value of the product.
     */
    public ProductModel(int productId, String name, Float value) {
        this.productId = productId;
        this.name = name;
        this.value = value;
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
     * Get the name of the product.
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of the product.
     * @return The value of the product.
     */
    public Float getValue() {
        return value;
    }

    /**
     * Set the value of the product.
     * @param value The value of the product.
     */
    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    /**
     * toString
     * @return The string representation of the product.
     */
    public String toString() {
        return "ProductModel [name=" + name + ", productId=" + productId + ", value=" + value + "]";
    }
}