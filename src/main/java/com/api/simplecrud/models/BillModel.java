package com.api.simplecrud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class BillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private int invoice;
    @Column(nullable = false)
    private int serialNumber;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String paymentType;
    @Column(nullable = false)
    private double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private StakeHolder receiver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issuing_id", referencedColumnName = "id")
    private StakeHolder issuing;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private List<BillDetailModel> billDetails;
}
