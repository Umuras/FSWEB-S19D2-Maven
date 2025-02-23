package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer", schema = "fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "salary")
    private Double salary;


    //Uni-directional bağ deniyor, buna. Addressde eğer Customer nesnesi tanımlanmazsa.
    //Bu şekilde CascadeType.ALL dediğimizde Customer kaydı silindiğinde addressdeki onla alakalı kaydıda
    //silinecek.
    @OneToOne(cascade = CascadeType.ALL)
    //Joinleyeceğimiz columnı belirliyoruz, yani foreign keyi.
    @JoinColumn(name = "address_id")
    //Bu şekilde Customer nesnesini çağırdığımız zaman otomatik olarak address nesnesini de çağırmış olacak.
    private Address address;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accounts = new ArrayList<>();
}
