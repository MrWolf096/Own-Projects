package com.howtodoinjava.hibernate.library;

import jakarta.persistence.*;

@Entity
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer idPersonC;


    @Column(name = "PersonCLa" +
            "stName", nullable = false)
    private String personLastName;

    @Column(name = "PersonCFirstName", nullable = false)
    private String personFirstName;
    @Column(name = "Gender", nullable = false)
    private String gender;

    @Column(name = "IDIdentification", unique = true, nullable = false)
    private Integer idIdentification;

    public Integer getIdPersonC() {
        return idPersonC;
    }

    public void setIdPersonC(Integer idPersonC) {
        this.idPersonC = idPersonC;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIdIdentification() {
        return idIdentification;
    }

    public void setIdIdentification(Integer idIdentification) {
        this.idIdentification = idIdentification;
    }

    @Override
    public String toString() {
        return "PersonClients{" +
                "idPersonC=" + idPersonC +
                ", personLastName='" + personLastName + '\'' +
                ", personFirstName='" + personFirstName + '\'' +
                ", gender='" + gender + '\'' +
                ", idIdentification=" + idIdentification +
                '}';
    }
}
