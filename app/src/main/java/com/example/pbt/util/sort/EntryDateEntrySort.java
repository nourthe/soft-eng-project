package com.example.pbt.util.sort;

import com.example.pbt.model.Entry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class EntryDateEntrySort implements EntryFilter {

    @Override
    public <T extends Entry> List<T> filter(List<T> list) {
        List sorted = new ArrayList<>();
        sorted.addAll(list);

        sorted.sort( new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                Date d1 = e1.getDate();
                Date d2 = e2.getDate();

                if (d1 == null) {
                    return d2 == null? 0 : 1;
                }
                else if (d2 == null) return -1;

                return (int) Math.signum(d1.compareTo(d2));
            }
        });

        return sorted;
    }
}
