package com.capg.CartService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cartss")
public class Cart {


    @Transient
    public static final String SEQUENCE_NAME = "cart_sequence";

    @Id
    private int cartId;
   // private int profileId;
   // private int productId;
    private double totalPrice;
    private List<Items> item;
    public Cart(int cartId, List<Items> item) {
        this.cartId = cartId;
        this.item = item;
    }



    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<Items> getItem() {
        return item;
    }

    public void setItem(List<Items> item) {
        this.item = item;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Item=" + item+
                ", cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return getCartId() == cart.getCartId() && Double.compare(cart.getTotalPrice(), getTotalPrice()) == 0 && getItem().equals(cart.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem(), getCartId(), getTotalPrice());
    }
}
