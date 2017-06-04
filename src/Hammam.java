import java.util.ArrayList;


public class Hammam<T extends Comparable<T>> {

    private ArrayList<T> items = new ArrayList<>();
    private ArrayList<Comparable> deletedItems = new ArrayList<>();
    //     private final Constructor<? extends T> ctor;
    private int size;

//     public Hammam(Constructor<? extends T> ctor) {
//         this.ctor = ctor;
//     }


    public int getSize() {
        return size;
    }

    public int compareTo(T o) {
        //TODO : overriding compareTo method
        return 0;
    }

    void add(T item) {
        System.out.println("Enter to add....");
        if (!items.contains(item) && item != null) items.add(item);
    }

    T getMin() throws IllegalStateException {
        T min = null;
        if (items.isEmpty()) throw new IllegalStateException();
        else {
            for (T item : items) {
                if (min == null) min = item;
                if (item.compareTo(min) == -1) min = item;
            }
        }
        return min;
    }

    T getLast(boolean remove) throws IllegalStateException {

        if (items.isEmpty()) {
            throw new IllegalStateException();
        }

        T last = items.get(items.size() - 1);
        if (!items.isEmpty()) {
            if (remove) {
                last = items.get(items.size() - 1);
                deletedItems.add(last);
                items.remove(items.size() - 1);
            }
        }
        return last;

    }

    T getFirst(boolean remove) throws IllegalStateException {
        ArrayList<Integer> index = new ArrayList<>();

        if (items.isEmpty()) throw new IllegalStateException();
        else {
            T first = items.get(0);
            for (T item : items) {
                index.add(items.indexOf(item));
            }
            int min = index.get(0);
            for (Integer i : index) if (i < min) min = i;
            if (remove) {
                first = items.get(min);
                deletedItems.add(first);
                items.remove(min);
            }
            return first;
        }
    }

    Comparable[] getLess(T element, boolean remove) throws NullPointerException {
        //   ArrayList<Integer> size = new ArrayList<>();
        Comparable[] less = new Comparable[items.size()];

        for (int i = 0; i < less.length; i++) {
            if (items.get(i).compareTo(element) == -1)
                less[i] = items.get(i);
            if (items.get(i) == null) throw new NullPointerException();

        }
        if (remove) {
            for (Comparable les : less) {
                deletedItems.add(les);
            }
            for (Comparable les : less) {
                items.remove(les);
            }
        }
        return less;
    }

    Comparable[] getRecentlyRemoved(int n) throws NullPointerException {
        if (items.isEmpty() || n < 0) throw new NullPointerException();//n=2
        Comparable[] removed = new Comparable[deletedItems.size()];
        Comparable[] all = new Comparable[deletedItems.size()];
        // T[] remove2 = null ;
        if (n > deletedItems.size()) {
            System.out.println("Enter one-----");
            System.out.println("DELETED ITEMS SIZE  : " + deletedItems.size());
            for (int i = 0; i <= deletedItems.size() - 1; i++) {
                all[i] = deletedItems.get(i);
                System.out.println("this is i " + i);
                System.out.println("this is all " + all[i] + "\n" + "this is deleted items : " + deletedItems.get(i));
            }
            return all;
        } else {
            System.out.println("Enter two----");
            System.out.println("DELETED ITEMS SIZE IS : " + deletedItems.size());
            for (int i = 0; i <= deletedItems.size() - 1; i++) {
                removed[i] = deletedItems.get(i);
            }
            reverseArray(removed);
            Comparable[] finalResult = new Comparable[removed.length];
            for (int i = 0; i <= n; i++) {
                finalResult[i] = removed[n];
            }
            return finalResult;
        }
    }

    //or (int i = 0  ; i<removed.size() ;  i++)
//        {
//            assert false;
//            remove2[i] = removed.get(i);
//        }
    private static void reverseArray(Comparable[] data) {

        for (int i = 0; i < data.length / 2; i++) {
            for (int j = data.length - 1; j > 0; j--) {
                Comparable temp = data[i];

                data[i] = data[j];

                data[j] = temp;

            }
        }
    }

}



