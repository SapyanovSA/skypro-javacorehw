package org.skypro.skyshop.search;

import org.skypro.skyshop.exeption.BestResultNotFound;

public class SearchEngine {

    Searchable[] searchables;
    int counter;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        counter = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int sizeCounter = 0;

        for (int index = 0; index < searchables.length; index++) {
            if (searchables[index] != null && searchables[index].getSearchTerm().contains(query)) {
                results[sizeCounter] = searchables[index];
                sizeCounter++;
            }

            if (sizeCounter == 5) {
                break;
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
        if (counter < searchables.length) {
            searchables[counter] = object;
            System.out.println(searchables[counter].getName() + " добавлен");
            counter++;
        }
    }
}
