package snabbköp;
import java.util.ArrayList;
import snabbköp.CustomerFactory.Customer;



public class FIFO {
    ArrayList<CustomerFactory.Customer> content = new ArrayList<CustomerFactory.Customer>();

    public void add(Customer c){
        content.add(c);
    }

    public Customer next(){
        Customer tmp = content.get(0);
        content.remove(0);
        return tmp;
    }
}
