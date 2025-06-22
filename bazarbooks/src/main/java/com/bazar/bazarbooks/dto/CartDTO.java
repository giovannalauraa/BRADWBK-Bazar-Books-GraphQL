package com.bazar.bazarbooks.dto;

import java.util.List;

public class CartDTO {
    private int id_cart;
    private int userId;
    private List<CartItemDTO> items;
    private double total;

    public CartDTO(int id_cart, int userId, List<CartItemDTO> items) {
        this.id_cart = id_cart;
        this.userId = userId;
        this.items = items;
        this.total = items.stream().mapToDouble(CartItemDTO::getSubtotal).sum();
    }

    public int getId_cart() { return id_cart; }
    public int getUserId() { return userId; }
    public List<CartItemDTO> getItems() { return items; }
    public double getTotal() { return total; }
}