package com.baziuk.keycloack.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Table(name = "client_info")
@Entity
@Data
public class ClientInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    @Email(message = "не вірний формат email")
    private String email;
    @Column(name = "tax_number")
    private String taxNumber;
    @Column(name = "location")
    private String location;
    @Column(name = "user_id")
    private Integer userId;

    public ClientInfoEntity(){}

    public ClientInfoEntity(Integer id, String name, String email, String taxNumber, String location, Integer userId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.taxNumber = taxNumber;
        this.location = location;
        this.userId = userId;
    }

    public ClientInfoEntity(String name, String email, String taxNumber, String location, Integer userId) {
        this.name = name;
        this.email = email;
        this.taxNumber = taxNumber;
        this.location = location;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getLocation() {
        return location;
    }

    public Integer getUserId() {
        return userId;
    }
}
