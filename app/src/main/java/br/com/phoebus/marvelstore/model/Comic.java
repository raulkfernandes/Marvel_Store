package br.com.phoebus.marvelstore.model;

public class Comic {
    private long id;
    private String title;
    private String price;

    public Comic(String title, String price) {
        this.setTitle(title);
        this.setPrice(price);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
