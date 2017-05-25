import java.util.ArrayList;


class Hamma <T extends Comparable<T>> implements Comparable<T> {

    ArrayList<T> items = new ArrayList<T>();
    ArrayList<T> deletedItems = new ArrayList<T>();
    @Override
    public int compareTo(T o) {
        return 0;
    }

    public void add(T item)
    {
        if(!items.contains(item)) items.add(item);
    }
    public T getMin() throws IllegalStateException {
        T min = null;
        if(items.isEmpty()) throw new IllegalStateException();
        else {
            for (T item : items) {
                if (min == null) min = item;
                if (compareTo(item) == 1) min = item;
            }
        }
        return min;
    }
    public T getLast (boolean remove) throws IllegalStateException {
        T last = null;
        if(items.isEmpty()) throw new IllegalStateException();
        else {
            if(remove) {
                last = items.get(items.size());
                deletedItems.add(last);
                items.remove(items.size());
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
        for (int i =items.size() ; i>=n ;i--)
        {
            removed.add(items.get(i));
        }
        return (T[]) removed.toArray();
    }


}
