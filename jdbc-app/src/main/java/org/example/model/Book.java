package org.example.model;

public class Book {
    private long id;
    private String title;

    private int rating;

    public Book(){

    }

    public Book(int id, String title, int rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
