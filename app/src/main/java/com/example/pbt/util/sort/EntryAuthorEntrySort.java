package com.example.pbt.util.sort;

import com.example.pbt.model.Entry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EntryAuthorEntrySort implements EntryFilter {

    @Override
    public <T extends Entry> List<T> filter(List<T> list) {
        List sorted = new ArrayList<>();
        sorted.addAll(list);

        sorted.sort( new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                String n1 = e1.getAuthor().getName();
                String n2 = e2.getAuthor().getName();

                return new StringComparator().compare(n1, n2);
            }
        });

        return sorted;
    }
}
