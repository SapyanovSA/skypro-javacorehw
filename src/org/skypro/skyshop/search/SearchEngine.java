package org.skypro.skyshop.search;

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

    public void add(Searchable object) {
        if (counter < searchables.length) {
            searchables[counter] = object;
            System.out.println(searchables[counter].getName() + " добавлен");
            counter++;
        }
    }
}
