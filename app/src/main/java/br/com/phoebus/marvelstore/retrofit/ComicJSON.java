package br.com.phoebus.marvelstore.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ComicJSON {

    // Fields used on JSON parser.

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("creators")
    @Expose
    private Creator creators;

    @SerializedName("prices")
    @Expose
    private ArrayList<Price> prices;

    @SerializedName("dates")
    @Expose
    private ArrayList<Date> dates;

    // Comic Fields

    private String publishedDate;

    private Boolean isRare;

    private String writers;

    private String pencilers;

    private String coverArtits;

    private double price;

    // Getters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Creator getCreators() {
        return creators;
    }

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public Boolean getRare() {
        return isRare;
    }

    public double getPrice() {
        return price;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getWriters() {
        if (writers != null) {
            return "Writer: " + writers;
        }
        return "No writers available";
    }

    public String getPencilers() {
        if (this.pencilers != null) {
            return "Penciler: " + pencilers;
        }
        return "No pencilers available";
    }

    public String getCoverArtits() {
        if (this.coverArtits != null) {
            return "Cover Artist: " + coverArtits;
        }
        return "No cover artists available";
    }

    // Setters

    public void setRare(Boolean rare) {
        this.isRare = rare;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void addWriter(String authorName) {
        if (authorName != null) {
            if (writers == null || writers.isEmpty()) {
                writers = authorName;
            } else {
                writers += ", " + authorName;
            }
        }
    }

    public void addPenciler(String authorName) {
        if (authorName != null) {
            if (pencilers == null || pencilers.isEmpty()) {
                pencilers = authorName;
            } else {
                pencilers += ", " + authorName;
            }
        }
    }

    public void addCoverArtist(String authorName) {
        if (authorName != null) {
            if (coverArtits == null || coverArtits.isEmpty()) {
                coverArtits = authorName;
            } else {
                coverArtits += ", " + authorName;
            }
        }
    }

    @Override
    public String toString() {
        return "Comic{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creators=" + creators +
                ", isRare=" + isRare +
                '}';
    }
}
