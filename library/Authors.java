package com.howtodoinjava.hibernate.library;

import jakarta.persistence.*;


@Entity
@Table(name="Authors")
public class Authors {
    @Id
    @GeneratedValue
    @Column(name="ID",unique = true,nullable = false)
    private Integer idAuthor;

    @Column(name="NameAuthor",nullable = false)
    private String name;

    @Column(name="SurnameAuthor",nullable = false)
    private String surnameAuthor;

    @Column(name="Age",nullable = false)
    private Integer age;

    @Column(name="YearsOfExperience",nullable = false)
    private Integer yearsOfExperience;

    @Column(name="Gender",nullable = false)
    private String gender;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                ", SurnameAuthor='" + surnameAuthor + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", gender='" + gender + '\'' +
                '}';
    }
}
