import java.util.ArrayList;


class Hamma <T> implements Comparable {

    ArrayList<T> items = new ArrayList<T>();
    ArrayList<T> deletedItems = new ArrayList<T>();
    @Override
    public int compareTo(Object o) {
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
                items.remove(min);
            }
        }
        return first;
    }
}
