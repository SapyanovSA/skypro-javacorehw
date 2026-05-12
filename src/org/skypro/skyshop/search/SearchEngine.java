package org.skypro.skyshop.search;

import org.skypro.skyshop.exeption.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.comparator.SearchNameComparator;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine{

    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String query) {

        return searchables.stream()
                .filter(s -> s.getSearchTerm().contains(query))
                .collect(Collectors.toCollection( () -> new TreeSet<>( new SearchNameComparator())));

    }

    public Searchable searchSuitable(String query) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;

        //Защита от бесконечного цикла
        if (query == null || query.isBlank()) {
            throw new BestResultNotFound(query);
        }

        for (Searchable current: searchables) {

            String searchTerm = current.getSearchTerm();
            int currentCount = 0;
            int index = 0;

            int substringIndex = searchTerm.indexOf(query, index);

            while (substringIndex != -1) {
                currentCount++;
                index = substringIndex + query.length();
                substringIndex = searchTerm.indexOf(query, index);
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                searchable = current;
            }
        }

        if (searchable == null) {
            throw new BestResultNotFound(query);
        }

        return searchable;
    }

    public void add(Searchable object) {
        searchables.add(object);
    }

}
