/**
 * Model some details of a product sold by a company.
 * 
 * @author Mohammed Loqman.
 * @version 2016.02.29
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // BMW M8 Grand Coupe
    private String name;
    // 1.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        /**
         * This will give value to the product
         */
        this.quantity = quantity;
    }
    
    public void increaseQuantity(int amount)
    {
        /**
         * This will increase the product quantity
         */
        quantity = quantity + amount;
    }
    
    public void decreaseQuantity(int amount)
    {
        /**
         * This will decrease the product quantity
         */
        if(quantity >= amount)
            quantity = quantity - amount;
    }
    
    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return " ID " + id + ": " +  name + " stock level: " + quantity;
    }

    
    public void print()
    {
        System.out.println(toString());
    }
}