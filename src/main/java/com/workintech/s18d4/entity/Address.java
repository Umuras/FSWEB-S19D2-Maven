package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "fsweb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street")
    private String street;
    @Column(name = "no")
    private int no;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "description")
    private String description;

    //Bu şekilde iki tarafta tanımlı olunca, bi-directional oluyor.
    //address nesnesi tarafından mapplendiğini söylüyoruz.
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "address")
    private Customer customer;


}
