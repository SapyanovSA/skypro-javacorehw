package org.skypro.skyshop.search;

import org.skypro.skyshop.exeption.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        int sizeCounter = 0;

        for (Searchable current : searchables) {
            if (current.getSearchTerm().contains(query)) {
                results.add(current);
            }
        }
        return results;
    }

    public Searchable searchSuitable(String query) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;

        //Защита от бесконечного цикла
        if (query == null || query.isBlank()) {
            throw new BestResultNotFound(query);
        }

        for (Searchable current: searchables) {
            if (current == null) {
                continue;
            }

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
