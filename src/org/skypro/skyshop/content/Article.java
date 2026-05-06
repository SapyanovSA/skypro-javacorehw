package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private final String name;
    private final String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "\n" + content;
    }
}
