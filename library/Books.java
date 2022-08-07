package com.howtodoinjava.hibernate.library;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="Books")
public class Books {
    @Id
    @GeneratedValue
    @Column(name="ID",unique = true,nullable = false)
    private Integer carteID;

    @Column(name="Title",unique = true,nullable = false)
    private String title;

    @Column(name="YearOfPublication",nullable = false)
    private Integer yearOfPublication;

    @Column(name="Category",nullable = false)
    private String categories;

    @Column(name="NrPages",nullable = false)
    private Integer nrPages;

    @Column(name="Status",nullable = false)
    private boolean status;

    @OneToMany
    List<Authors> authors;

    @OneToOne
    PublishingHouse publishingHouse;

    @OneToMany
    List<ReviewAndStar> reviewAndStars;

    @OneToMany
    List<Person> personClients;

    public Integer getCarteID() {
        return carteID;
    }

    public void setCarteID(Integer carteID) {
        this.carteID = carteID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getNrPages() {
        return nrPages;
    }

    public void setNrPages(Integer nrPages) {
        this.nrPages = nrPages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<ReviewAndStar> getReviewAndStars() {
        return reviewAndStars;
    }

    public void setReviewAndStars(List<ReviewAndStar> reviewAndStars) {
        this.reviewAndStars = reviewAndStars;
    }

    public List<Person> getPersonClients() {
        return personClients;
    }

    public void setPersonClients(List<Person> personClients) {
        this.personClients = personClients;
    }

    @Override
    public String toString() {
        return "Books{" +
                "carteID=" + carteID +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", categories='" + categories + '\'' +
                ", nrPages=" + nrPages +
                ", status=" + status +
                ", authors=" + authors +
                ", publishingHouse=" + publishingHouse +
                ", reviewAndStars=" + reviewAndStars +
                ", personClients=" + personClients +
                '}';
    }
}
