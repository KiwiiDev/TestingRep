package com.ewe.kevin210.webapp.customer.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.springframework.util.*;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    private int id;

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private Date birthdate;
    @NotNull
    private String gender;

    private int zipcode;
    @NotNull
    private String street;

    private int housenumber;
    @NotNull
    private String city;
    private String email;


    public Customer() {
    }

    public Customer(Customer customer) {

        this.id = 101;
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.birthdate = customer.getBirthdate();
        this.gender = customer.getGender();
        this.zipcode = customer.getZipcode();
        this.street = customer.getStreet();
        this.housenumber = customer.getHousenumber();
        this.city = customer.getCity();
        this.email = customer.getEmail();
    }

    public Customer(String firstname, String lastname, Date birthdate, String gender, int zipcode, String street, int housenumber, String city, String email) {
        id = 101;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.zipcode = zipcode;
        this.street = street;
        this.housenumber = housenumber;
        this.city = city;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                zipcode == customer.zipcode &&
                housenumber == customer.housenumber &&
                Objects.equals(firstname, customer.firstname) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(birthdate, customer.birthdate) &&
                Objects.equals(gender, customer.gender) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname, birthdate, gender, zipcode, street, housenumber, city, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", zipcode=" + zipcode +
                ", street='" + street + '\'' +
                ", housenumber=" + housenumber +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
