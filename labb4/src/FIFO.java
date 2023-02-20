// Anton Nyström
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {

    private ArrayList<Object> data;
    private int maxSize;

    public FIFO() {
        this.data = new ArrayList<Object>();
        this.maxSize = 0;
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public int maxSize() {
        return this.maxSize;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object first() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        // Returnera första elementet i listan
        return this.data.get(0);
    }

    @Override
    public boolean equals(Object f) throws ClassCastException {
        if (!(f instanceof FIFO) ) {
            throw new ClassCastException();
        }

        // Downcasta f till FIFO
        FIFO other = (FIFO) f;

        // Måste ha samma längd
        if (this.size() != other.size()) {
            return false;
        }
        
        // Jämför varje index 
        for (int i = 0; i < this.size(); i++) {
            if (this.data.get(i) == null) {
                if (other.data.get(i) == null) {
                    // Element OK
                    continue;
                } else {
                    return false;
                }
            } else if (other.data.get(i) == null) {
                if (this.data.get(i) == null) {
                    // Element OK
                    continue;
                } else {
                    return false;
                }
            } else {
                if (this.data.get(i).equals(other.data.get(i))) {
                    // this.data.get(i) == other.data.get(i) 
                    // blir inte OK i FIFOmain test funktionen
                    
                    // Element OK
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "Queue: ";

        for (int i = 0; i < this.size(); i++) {
            Object element = this.data.get(i);
            result = result + "(" + String.valueOf(element) + ") ";
        }

        return result;
    }

    @Override
    public void add(Object arg0) {
        // Lägg till sist i listan
        this.data.add(arg0);

        // Uppdatera max size
        this.maxSize = this.size() > this.maxSize ? this.size() : this.maxSize;
    }

    @Override
    public void removeFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        // Ta bort det första elementet i listan
        this.data.remove(0);
    }
}
