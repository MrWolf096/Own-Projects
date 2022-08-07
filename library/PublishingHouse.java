package com.howtodoinjava.hibernate.library;

import jakarta.persistence.*;

@Entity
@Table(name="PublishingHouse")
public class PublishingHouse {


        @Id
        @GeneratedValue
        @Column(name="ID",unique = true,nullable = false)
        private Integer publishingHouseID;

        @Column(name="NamePublishingHouse",unique = true,nullable = false)
        private String namePublishingHouse;

        @Column(name="YearOfAppear",nullable = false)
        private Integer yearOfAppear;

        @Column(name="Rating",unique = true,nullable = false)
        private Integer rating;

    public Integer getPublishingHouseID() {
        return publishingHouseID;
    }

    public void setPublishingHouseID(Integer publishingHouseID) {
        this.publishingHouseID = publishingHouseID;
    }

    public String getNamePublishingHouse() {
        return namePublishingHouse;
    }

    public void setNamePublishingHouse(String namePublishingHouse) {
        this.namePublishingHouse = namePublishingHouse;
    }

    public Integer getYearOfAppear() {
        return yearOfAppear;
    }

    public void setYearOfAppear(Integer yearOfAppear) {
        this.yearOfAppear = yearOfAppear;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "publishingHouseID=" + publishingHouseID +
                ", namePublishingHouse='" + namePublishingHouse + '\'' +
                ", yearOfAppear=" + yearOfAppear +
                ", rating=" + rating +
                '}';
    }
}
