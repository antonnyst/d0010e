package snabbköp;
import java.util.ArrayList;
import java.util.Arrays;

import snabbköp.CustomerFactory.Customer;



public class FIFO {
    ArrayList<CustomerFactory.Customer> content = new ArrayList<CustomerFactory.Customer>();

    public void add(Customer c){
        content.add(c);
    }

    public Customer next(){
        return content.remove(0);
    }

    @Override
    public String toString() {
        int[] tmp = new int[content.size()];
        for(int i = 0; i < content.size(); i++){
            tmp[i] = (content.get(i).id);
        }
        return Arrays.toString(tmp);
    }

    public Boolean hasNext(){
        if (content.size() != 0){
            return true;
        }
        else{
            return false;
        }
    }
}
