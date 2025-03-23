package com.food.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "Dealer_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Transactional
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEALER_ID")
    Integer dealerCode;
    @Column(name = "DEALER_NAME")
    String dealerName;
    @Column(name = "DEALER_PHONE")
    String dealerContactNo;
    @Column(name = "DEALER_CITY")
    String dealerCity;
    @Column(name = "DEALER_DETAILS")
    String dealerDetails;
    @Column(name = "DEALER_STATUS")
    String dealerStatus;
    @Column(name = "DEALER_INSERTED_BY")
    String dealerInsertedBy;
}
