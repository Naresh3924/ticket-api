package com.tnova.ticketapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MovieRequestDTO {

    @NotNull(message = "Title is required")
    private String title;

    @Min( value = 0, message = "rating cannot be negative")
    @Max(value=10, message = "Rating must be realistic")
    private double rating;

    @Min(value = 1,message = "Release year must be positive")
    private int releaseYear;



    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
}
