package snabbköp;

public class CustomerFactory {
    private int nextId;

    public class Customer {
        public final int id;
        private Customer(int id) {
            this.id = id;
        }
    }
    
    public CustomerFactory() {
        nextId = 0;
    }

    public Customer getCustomer() {
        Customer customer = new Customer(nextId);
        nextId++;
        return customer;
    }
}
