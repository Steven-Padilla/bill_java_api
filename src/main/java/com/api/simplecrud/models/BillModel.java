package com.api.simplecrud.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private StakeHolder receiver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issuing_id", referencedColumnName = "id")
    private StakeHolder issuing;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private List<BillDetailModel> billDetails;
}
