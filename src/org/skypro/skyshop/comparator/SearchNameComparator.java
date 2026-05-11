package org.skypro.skyshop.comparator;

import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;

public class SearchNameComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable pr1, Searchable pr2) {
        int results = Integer.compare(pr2.getName().length(), pr1.getName().length());
        if (results != 0) {
            return results;
        }
        return pr1.getName().compareTo(pr2.getName());
    }
}
