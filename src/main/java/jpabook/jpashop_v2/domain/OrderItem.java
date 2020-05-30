package jpabook.jpashop_v2.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@Table(name="order_item")
public class  OrderItem
{
    @GeneratedValue
    @Id @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="order_id")
    private Order order;//주문

    @Column(name = "order_price")
    private int orderPrice;// 주문 가격

    private int count;// 주문 수량

}
