

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Mohammed Loqman.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Here are the products that will be used 
        // They all have theire own uniqe ID number
        
        stock.add(new Product(101, "BMW M8 Grand Coupe"));
        stock.add(new Product(102, "Mercedes AMG GT Black Series"));
        stock.add(new Product(103, "ABT Audi R8 V10 Performace Quattro"));
        stock.add(new Product(104, "ABT RS3"));
        stock.add(new Product(105, "Brabus E63S AMG"));
        stock.add(new Product(106, "Lamborghini aventador SVJ"));
        stock.add(new Product(107, "ABT RS6"));
        stock.add(new Product(108, "Lamborghini hurrican performante"));
        stock.add(new Product(109, "BMW M5 Competition"));
        stock.add(new Product(110, "Brabus Rocket 900"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101,10);
        stock.buyProduct(102,9);
        stock.buyProduct(103,5);
        stock.buyProduct(104,5);
        stock.buyProduct(105,7);
        stock.buyProduct(106,4);
        stock.buyProduct(107,2);
        stock.buyProduct(108,1);
        stock.buyProduct(109,8);
        stock.buyProduct(110,4);
    }

    private void sellProducts()
    { 
        stock.sellProduct(101,5);
        stock.sellProduct(102,5);
        stock.sellProduct(103,8); 
        stock.sellProduct(104,2); 
        stock.sellProduct(105,4); 
        stock.sellProduct(106,1); 
        stock.sellProduct(107,1); 
        stock.sellProduct(108,6); 
        stock.sellProduct(109,6); 
        stock.sellProduct(110,3); 
    }    
}