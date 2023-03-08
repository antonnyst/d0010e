/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package snabbköp;

/**
* Fabrik för att att skapa kunder med unika id.
*/
public class CustomerFactory {
    private int nextId;

    /**
    * Intern klass för kunder som lagrar en int som id
    */
    public class Customer {
        public final int id;
        private Customer(int id) {
            this.id = id;
        }
    }

    /**
    * Konstruktor för CustomerFactory.
    */
    public CustomerFactory() {
        nextId = 0;
    }

    /**
    * Returnerar nästa kund 
    * @return Nästa kund som en Customer
    */
    public Customer getCustomer() {
        Customer customer = new Customer(nextId);
        nextId++;
        return customer;
    }
}
