import java.util.ArrayList;


 public class Hammam<T extends Comparable<T>> implements Comparable<T> {

    ArrayList<T> items = new ArrayList<T>();
    ArrayList<T> deletedItems = new ArrayList<T>();
    @Override
    public int compareTo(T o) {
        //TODO : overriding compareTo method
     return 0;
    }

    public void add(T item)
    {
        System.out.println("Enter to add....");
        if(!items.contains(item) && item!=null) items.add(item);
    }

    public T getMin() throws IllegalStateException {
        T min = null;
        if(items.isEmpty()) throw new IllegalStateException();
        else {
            for (T item : items) {
                if (min == null) min = item;
                if (item.compareTo(item) == 1) min = item;
            }
        }
        return min;
    }
    public T getLast (boolean remove) throws IllegalStateException {
        T last = null;
        if(items.isEmpty()) throw new IllegalStateException();
        else {
            if(remove) {
                last = items.get(items.size()-1);
                deletedItems.add(last);
                items.remove(items.size()-1);
            }
        }
        return last;
    }
    public T getFirst(boolean remove) throws IllegalStateException {
        T first = null;
        ArrayList<Integer> index = new ArrayList<>();
        if (items.isEmpty()) throw new IllegalStateException();
        else {
            for (T item : items) {
                index.add(items.indexOf(item));
            }
            int min = index.get(0);
            for (Integer i : index) if (i < min) min = i;
            if (remove){
                first = items.get(min);
                deletedItems.add(first);
                items.remove(min);
            }
        }
        return first;
    }
    public T[] getLess (T element , boolean remove){

        ArrayList <T> less = new ArrayList<T>();
        for (T item:items)
        {
            if(item.compareTo(element) == -1) less.add(item);
        }
        if(remove)
        {
            for (T item : less)
            {
                deletedItems.add(item);
            }
            for (int i = 0 ; i<less.size() ;i++)
            {
                items.remove(less.get(i));
            }
        }
        return (T[]) less.toArray();
    }
    public T[] getRecentlyRemoved(int n)
    {
        ArrayList<T> removed = new ArrayList<T>();
        for (int i =deletedItems.size()-1 ; i>n ;i--)
        {
            removed.add(deletedItems.get(i));
        }
        T[] remove2 = (T[])removed.toArray();
        for (int i = 0  ; i<removed.size() ;  i++)
        {
            remove2[i] = removed.get(i);
        }
        return remove2;
    }

     public ArrayList<T> getItems() {
         return items;
     }

     public ArrayList<T> getDeletedItems() {
         return deletedItems;
     }

     public static void main(String[] args) {
         Hammam<Integer> hammam = new Hammam<>();
         hammam.add(12345);
         hammam.add(0000);
         hammam.add(1111);
         ArrayList<Integer> numbers = new ArrayList<>();
         numbers = hammam.getItems();
         Integer p = hammam.getLast(true);
         ArrayList<Integer> integers = new ArrayList<>();
         Integer [] integers1 = new Integer[5];
         integers1 = hammam.getRecentlyRemoved(0);
         //int out  = hammam.getFirst(false);
         System.out.println(numbers + "...................." + p + "\n "  + integers1);
     }


}
