package com.api.simplecrud.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billdetails")
public class BillDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String item;

    @Column
    private int quantity;

    @Column
    private double singlePrice;

    @Column
    private String description;

    @Column
    private double total;



}
