import java.util.ArrayList;
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Mohammed Loqman
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    public StockList stock;
    public Product product;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
   private boolean executeChoice(String choice)
   /**
    * T his helps to prent the user with a list of choices to manipulate the stock app.
    */
    {
        if(choice.equals("print"))
        {
            printProducts();
        }
        else if(choice.equals("quit"))
        {
             quitApp();
        }
        else if(choice.equals("add"))
        {
             addProducts();
        }
        else if(choice.equals("remove"))
        {
             removeProducts();
        }
        else if(choice.equals("buy"))
        {
             buyProducts();
        }
        else if(choice.equals("sell"))
        {
             sellProducts();
        }
        else if(choice.equals("search"))
        {
             searchProduct();
        }
        else if(choice.equals("low stock"))
        {
             lowStockProducts();
        }
        else if(choice.equals("restock"))
        {
             autoRestock();
        }
        return false;
     }
    //METHODS IN TESTING ORDER

    /**
     * Prints out the product and its stock level to the terminal.
     */
    public void printProducts()
    {
        System.out.println("The stock:");
        stock.print();
    }

    /**
     * Quits the app.
     */
    public void quitApp()
    {
        System.out.println("The app will now quit.");
        System.exit(0);
    }

    /**
     * Adds a product to the product list.
     */
    public void addProducts()
    {
        int id = reader.getInt("Please enter the ID: ");
        String name = reader.getString("Please enter the name of the product: ");
        Product product = new Product(id, name);
        stock.add(product);
        System.out.println("Product" + product.getID() + ", " + product.getName() + " has been ADDED.");
    }

    /**
     * Removes a product from the product list.
     */
    public void removeProducts()
    {
        int id = reader.getInt("Please enter the ID: ");
        String name = reader.getString("Please enter the name of the product: ");
        Product product = stock.findProduct(id);
        stock.remove(product);
        System.out.println("Product" + product.getID() + ", " + product.getName() + "has been REMOVED.");
    }

    /**
     * Adds a user determined number of stock for a chosen product.
     */
    public void buyProducts()
    {
        int id = reader.getInt("Please enter the ID: ");
        int amount = reader.getInt("Please enter the quantity of the product you would like to buy: ");
        Product product = stock.findProduct(id);
        stock.buyProduct(id,amount);
        stock.print();
        System.out.println("Bought " + amount + " of " + product);
    }

    /**
     * Subtracts a user determined number of stock for a chosen product.
     */
    public void sellProducts()
    {
        int id = reader.getInt("Please enter the ID: ");
        int amount = reader.getInt("Please enter the quantity of the product you would like to sell: ");

            if(product != null)
            {
                if(product.getQuantity() > 0)
                {
                    product.decreaseQuantity(amount);
                    System.out.println("Sold " + amount + " of "
                            + product.getName());
                }
                else
                {
                    System.out.println("The product " + product.getName()
                            + " is out of stock");
                }
            }
            else
            {
                System.out.println("Couldn't find product");
            }
    }

    /**
     * Finds and prints products based on an input String name.
     */
    private void searchProduct()
    {  
        int id = reader.getInt("Please enter the ID: "); 
        String name = reader.getString("Please enter the name of the product: ");
        Product product = new Product(id, name);
        
        stock.print();
        System.out.println(" ID: "+ product.getID()
            + "," + " " + "Product:" + " " + product.getName() + " Has been found");
    }

    /**
     * Prints a list of products that are low in stock.
     */
    public void lowStockProducts()
    {
        
        
            if(product.quantity <= 3)
            {
                System.out.println(product);
            }
        
    }

    /**
     * Restocks products significantly that have fallen below a predetermined level of stock.
     */
    public void autoRestock()
    {
        
        
            if (product.quantity <= 3)
            {
                product.increaseQuantity(10);
            }
        
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();   
        System.out.println("    Print:      Prints products");
        System.out.println("    Quit:       Quits application");
        System.out.println("    Add:        Add products");
        System.out.println("    Remove:     Remove product");
        System.out.println("    Buy;        Buy product");
        System.out.println("    Sell;       Sell product");
        System.out.println("    Search;     Search product");
        System.out.println("    Low stock;  Prints a list of items that are low on stock");
        System.out.println("    restock;    Restocks items that are low on stock");
        System.out.println();
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Mohammed Loqman");
        System.out.println("********************************");
    }
}