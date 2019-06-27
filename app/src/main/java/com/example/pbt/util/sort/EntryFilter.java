package com.example.pbt.util.sort;

import com.example.pbt.model.Entry;

import java.util.List;

public interface EntryFilter {
    <T extends Entry> List<T> filter(List<T> list);
}
