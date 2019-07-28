package br.com.phoebus.marvelstore.model;

import java.io.Serializable;

public class Comic implements Serializable {

    private String title;

    private String description;

    private String publishedDate;

    private boolean isRare;

    private String writers;

    private String pencilers;

    private String coverArtists;

    private double price;

    public Comic(String title, String price) {
        this.title = title;
        this.price = Double.valueOf(price);
        this.publishedDate = "27-12-2019";
        this.writers = "John Lennon, Ringo Star";
        this.pencilers = "Paul";
        this.coverArtists = "George";
        this.description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    }

    // Complete Constructor
    public Comic(String title, String description, String publishedDate, boolean isRare, String writers, String pencilers, String coverArtists, double price) {
        this.setTitle(title);
        this.setDescription(description);
        this.setPublishedDate(publishedDate);
        this.setRare(isRare);
        this.setWriters(writers);
        this.setPencilers(pencilers);
        this.setCoverArtists(coverArtists);
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isRare() {
        return isRare;
    }

    public void setRare(boolean rare) {
        isRare = rare;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getPencilers() {
        return pencilers;
    }

    public void setPencilers(String pencilers) {
        this.pencilers = pencilers;
    }

    public String getCoverArtists() {
        return coverArtists;
    }

    public void setCoverArtists(String coverArtists) {
        this.coverArtists = coverArtists;
    }

    public double getPriceDouble() {
        return price;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getTitle() + " " + getPrice();
    }
}
