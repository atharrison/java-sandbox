package atharrison.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aharrison on 3/11/15.
 */
public class UniqueInSortedLists {

    // a = [1, 2, 3, 4, 5]
// b = [1, 3, 5, 7, 9]
// result = [1, 3, 5]
    public Integer[] solve() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 3, 5, 7, 9};
        return unique(a, b);
    }

    public Integer[] unique(int[] a, int[] b) {

        //a and b are sorted
        List<Integer> results = new ArrayList<Integer>(Math.min(a.length, b.length));

        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            //which one has the smallest?


            int item = a[aIndex];
            if (item == b[bIndex]) {
                results.add(item);
                aIndex++;
                if(aIndex < a.length)
                    item = a[aIndex];

            } else if (item < b[bIndex]) {
                aIndex++;
                if(aIndex < a.length)
                    item = a[aIndex];
            } else { //item > b[bIndex]
                bIndex++;
            }
        }
        return results.toArray(new Integer[results.size()]);
    }
}

/*
public solve(int[] a, int[] b) {

    //a and b are sorted
    List<Integer> result = new ArrayList<Integer>(Math.min(a.length,b.length));

    int aIndex = 0;
    int bIndex = 0;
    while(aIndex < a.length && bIndex < b.length) {
        //which one has the smallest?


        int item = a[aIndex];
        if(item == b[bIndex]) {
            results.add(item);
            aIndex++;
            item = a[aIndex];
        } else if (item < b[bIndex]) {
            aIndex++;
            item = a[aIndex];
        } else { //item > b[bIndex]
           bIndex++;
        }
    }
    return results.toArray();//pseudo
}
 */
