package com.api.simplecrud.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billdetails")
@ToString
public class BillDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long details_id;

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
