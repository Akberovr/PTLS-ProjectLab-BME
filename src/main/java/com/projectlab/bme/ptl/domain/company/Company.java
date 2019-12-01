package com.projectlab.bme.ptl.domain.company;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private @NotBlank(message = "Field can not be blank") String first_name;


    private @NotBlank(message = "Field can not be blank") String last_name;


    private @NotBlank(message = "Field can not be blank") String email;


    public Company() {
    }

    public Company(@NotBlank(message = "Field can not be blank") String first_name, @NotBlank(message = "Field can not be blank") String last_name, @NotBlank(message = "Field can not be blank") String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
