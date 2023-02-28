package snabbköp;
import java.util.ArrayList;
import snabbköp.CustomerFactory.Customer;



public class FIFO {
    ArrayList<CustomerFactory.Customer> content = new ArrayList<CustomerFactory.Customer>();

    public void add(Customer c){
        content.add(c);
    }

    public Customer next(){
        return content.remove(0);
    }
}
