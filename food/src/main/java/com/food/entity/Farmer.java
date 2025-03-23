package com.food.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="Farmer_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Transactional
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="FMR_ID")
    Integer farmerId;
    @Column(name ="FMR_FIRST_NAME")
    String firstName;
    @Column(name ="FMR_LAST_NAME")
    String lastName;
    @Column(name ="FMR_MOB_NO")
    String mobileNo;
    @Column(name ="FMR_MILK_TYPE")
    String milkType;
    @Column(name = "FMR_CITY")
    String city;
}
