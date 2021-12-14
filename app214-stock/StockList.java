import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Mohammed Loqman) 
 * @version (02/11/2021)
 */
public class StockList
{
    // A list of the products.
    public ArrayList<Product> stock;
    
    private int ammountRequired;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    public void remove(Product item)
    {
        stock.remove(item);
    }
    
    public void RemoveProduct(int productID)
    {  
        /**
         * This helps to remove products depending on its unique ID Number
         */
        Product product = findProduct(productID);
        stock.remove(product);
    }
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    { 
        Product product = findProduct(productID) ;
        product.increaseQuantity(amount); 
    }

    /**
     * Check levels of stock 
     * If the stock is less than minimum it will buy in store
     */
    public void lowStockList()
    {
        printHeading();
        for(Product product : stock) 
            {
            if(product.getQuantity() < 3)
                product.increaseQuantity(10);
            }
            System.out.println();
        for(Product product : stock)
            {
                product.print();
            }
    }
    
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
    for(Product product : stock)
    { 
          if(product.getID() == productID)
          {
              return product;
            }
    }
    return null;
    }
    
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public String sellProduct(int productID, int amount) 
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0)
            {
                product.decreaseQuantity(amount);
                System.out.println("sold " + " of "
                + product.getName());
                // printout message
                return String.valueOf(product.getQuantity());
            }
            else
            {
                System.out.println("The product " + product.getName()
                + " is out of stock ");
                // printout message
                return "";
            }
        }
        else
        {
            // printout message
            return"Product out of stock";
        }
    }    

    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        /**
         * This is what my stocklist is called
         */
        System.out.println();
        System.out.println(" Mohammed Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}