package com.bazar.bazarbooks.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CartItem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart_item")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(name = "id_book", nullable = false)
    private Integer bookId;

    @Column(name = "uni_price", nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private int quantity;

    public CartItem() {}

    public CartItem(Integer id, Cart cart, Integer bookId, double unitPrice, int quantity) {
        this.id = id;
        this.cart = cart;
        this.bookId = bookId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Transient
    public double getSubtotal() {
        return unitPrice * quantity;
    }
}