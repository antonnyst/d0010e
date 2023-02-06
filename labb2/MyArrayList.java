package labb2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@SuppressWarnings("serial")
public class MyArrayList<E> implements Serializable, Cloneable, Iterable<E>,
		Collection<E>, List<E>, RandomAccess {

    	// ---------------------------------------------------------------

	public static void main(String[] args) {
		MyArrayList<String> strlist = new MyArrayList<String>();
		
		// testa metoder härifrån

		System.out.println("Hello world!");
		for (int i = 0; i<25; i++) {
			strlist.add(""+i);
		}

		System.out.println("Size : " + strlist.size());
		
		strlist.removeRange(10,10);

		System.out.println("Size : " + strlist.size());
		// Visa listan
		for (int i = 0; i < strlist.size(); i++) {
			System.out.println(strlist.get(i));
		}
	}

    // ---------------------------------------------------------------
    
	private E[] array;
	private int counter;

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}
		init(initialCapacity);
	}

	public MyArrayList() {
		init(10);
	}

	private void init(int size) {
		array = (E[]) new Object[size];
		counter = 0;
	}


	// -- 1 --

	@Override
	public int size() {
	    return counter;
	}

	@Override
	public boolean isEmpty() {
		return counter == 0;
	}

	@Override
	public void clear() {
		counter = 0;
	}

	// -- 2 --

	public void ensureCapacity(int minCapacity) {
		if (array.length < minCapacity) {
			// Vi behöver en större array
			int newCapacity = Math.max(array.length + 10, minCapacity);
			resize(newCapacity);
		}
	}

	public void trimToSize() {
		resize(size());
	}
    
	private void resize(int size) {
		// Skapa ny array och kopiera över värden
		E[] newArray = (E[]) new Object[size];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}

	// -- 3 --
    
	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		// Se till att det finns plats
		ensureCapacity(size() + 1);

		if (index < size()) {
			// Flytta element åt höger
			for (int i = size(); i > index; i--) {
				array[i] = array[i - 1];
			}
		}

		array[index] = element;
		counter++;
	}

	@Override
	public boolean add(E e) {
		add(counter, e);
		return true;
	}

    // -- 4 --
    
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return array[index];
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		E prev = get(index);
		array[index] = element;
		return prev; 
	}

	// -- 5 --

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		E removed = get(index);

		// Flytta element åt vänster
		for (int i = index; i < size()-1; i++) {
			array[i] = array[i+1];
		}

		counter--;
		return removed; 
	}

	protected void removeRange(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex >= size() || toIndex > size() || toIndex < fromIndex) {
			throw new IndexOutOfBoundsException();
		}

		int diff = toIndex - fromIndex;

		// Flytta element diff steg åt vänster
		for (int i = toIndex; i <= Math.min(toIndex + diff, size()-1); i++) {
			array[i-diff] = array[i];
		}

		counter -= diff;
	}

	// -- 6 --

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size(); i++) {
			if (o == null) {
				if (get(i) == null) {
					return i;
				}
			} else {
				if (o.equals(get(i))) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index < 0) {
			// Elementet fanns ej
			return false;
		}
		remove(index);
		return true; 
	}
    
	@Override
	public boolean contains(Object o) {
		int index = indexOf(o);
		if (index >= 0) {
			// Elementet finns
			return true;
		} else {
			return false; 
		}
	}

	// -- 7 --

	@Override
	public Object clone() {
		// Skapa ny arraylist med samma kapacitet
		MyArrayList<E> cloned = new MyArrayList<E>(array.length);

		// "Kopiera" över elementen
		for (int i = 0; i < size(); i++) {
			cloned.array[i] = array[i];
		}
		cloned.counter = counter;

		return cloned;
	}

	@Override
	public Object[] toArray() {
		// Skapa en ny array och kopiera elementen
		Object[] new_array = new Object[size()]; 
		for (int i = 0; i < size(); i++) {
			new_array[i] = array[i];
		}
		return new_array;
	}

	// --- Rör ej nedanstående kod -----------------------------------

	public MyArrayList(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	private class InternalIterator implements Iterator {
		int current = 0;

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public Object next() {
			return get(current++);

		}

	}

	@Override
	public Iterator<E> iterator() {
		return new InternalIterator();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void forEach(Consumer<? super E> action) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Spliterator<E> spliterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void replaceAll(UnaryOperator<E> operator) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sort(Comparator<? super E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

}
