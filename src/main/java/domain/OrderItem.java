package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class OrderItem {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @JoinColumn(name = "ORDER_ID")
    @ManyToOne
    private Order order;

    @JoinColumn(name = "ITEM_ID")
    @ManyToOne
    private Item item;

    private int orderPrice;
    private int count;

}
