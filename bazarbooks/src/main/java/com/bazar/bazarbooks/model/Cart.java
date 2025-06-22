package com.bazar.bazarbooks.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private int id_cart;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false, unique = true)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items;

    public Cart() {}

    public Cart(User user) {
        this.user = user;
    }

    public int getId() {
        return id_cart;
    }

    public void setId(int id) {
        this.id_cart = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    @Transient
    public double getTotal() {
        return items.stream()
                    .mapToDouble(CartItem::getSubtotal)
                    .sum();
    }
}