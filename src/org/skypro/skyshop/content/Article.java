package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private String name;
    private String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return name + " - " + content;
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
