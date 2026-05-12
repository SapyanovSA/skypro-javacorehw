package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article a)) return false;
        return Objects.equals(name, a.name);
    }
}
