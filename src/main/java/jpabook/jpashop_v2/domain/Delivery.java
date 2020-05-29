package jpabook.jpashop_v2.domain;

import javax.persistence.*;

@Entity
public class Delivery
{
    @Id
    @GeneratedValue
    @Column(name="DELIVERT_ID")
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery")
    private Orders order;

}
