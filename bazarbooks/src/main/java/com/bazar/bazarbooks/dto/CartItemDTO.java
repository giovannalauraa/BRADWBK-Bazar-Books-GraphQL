package com.bazar.bazarbooks.dto;

public class CartItemDTO {
    private int id;
    private int bookId;
    private double unitPrice;
    private int quantity;
    private double subtotal;

    public CartItemDTO(int id, int bookId, double unitPrice, int quantity) {
        this.id = id;
        this.bookId = bookId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = unitPrice * quantity;
    }

    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }
}
