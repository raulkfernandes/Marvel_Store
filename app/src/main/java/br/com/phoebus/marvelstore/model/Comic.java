package br.com.phoebus.marvelstore.model;

public class Comic {
    private long id;
    private String title;
    private String price;
    private String writer;
    private String penciler;
    private String coverArtist;
    private String publishedDate;
    private String description;

    public Comic(String title, String price) {
        this.setTitle(title);
        this.setPrice(price);
        this.setWriter("John");
        this.setPenciler("Paul");
        this.setCoverArtist("Patrick");
        this.setPublishedDate("27 December, 1996");
        this.setDescription("Very funny, Dr. Jones!");
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPenciler() {
        return penciler;
    }

    public void setPenciler(String penciler) {
        this.penciler = penciler;
    }

    public String getCoverArtist() {
        return coverArtist;
    }

    public void setCoverArtist(String coverArtist) {
        this.coverArtist = coverArtist;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
