package com.bazar.bazarbooks.controller;

import com.bazar.bazarbooks.dto.CartDTO;
import com.bazar.bazarbooks.dto.CartItemDTO;
import com.bazar.bazarbooks.dto.CartItemInput;
import com.bazar.bazarbooks.model.Cart;
import com.bazar.bazarbooks.model.CartItem;
import com.bazar.bazarbooks.service.CartItemService;
import com.bazar.bazarbooks.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    // ======== QUERIES ============

    @QueryMapping
    public CartDTO cartByUserId(@Argument int userId) {
        Cart cart = cartService.getCartByUserId(userId);
        List<CartItemDTO> itemDTOs = cart.getItems().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
        return new CartDTO(cart.getId(), cart.getUser().getIdUser(), itemDTOs);
    }

    @QueryMapping
    public List<CartItemDTO> cartItemsByCartId(@Argument int cartId) {
        return cartItemService.getItemsByCartId(cartId)
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    // ======= MUTATIONS ===========

    @MutationMapping
    public CartDTO createCart(@Argument int userId) {
        Cart cart = cartService.createCartIfNotExists(userId);
        return new CartDTO(cart.getId(), cart.getUser().getIdUser(), List.of());
    }

    @MutationMapping
    public CartItemDTO addCartItem(@Argument int cartId, @Argument CartItemInput item) {
        CartItem newItem = new CartItem();
        newItem.setBookId(item.getBookId());
        newItem.setUnitPrice(item.getUnitPrice());
        newItem.setQuantity(item.getQuantity());

        CartItem saved = cartItemService.addOrUpdateItem(cartId, newItem);
        return toDTO(saved);
    }

    @MutationMapping
    public CartItemDTO updateCartItemQuantity(@Argument int cartId, @Argument int itemId, @Argument int quantity) {
        CartItem item = cartItemService.updateQuantity(cartId, itemId, quantity);
        return toDTO(item);
    }

    @MutationMapping
    public Boolean deleteCartItem(@Argument int cartId, @Argument int itemId) {
        cartItemService.deleteItem(cartId, itemId);
        return true;
    }

    @MutationMapping
    public Boolean clearCart(@Argument int cartId) {
        cartItemService.clearCart(cartId);
        return true;
    }

    // ======= MAPPER AUX ==========

    private CartItemDTO toDTO(CartItem item) {
        return new CartItemDTO(
            item.getId(),
            item.getBookId(),
            item.getUnitPrice(),
            item.getQuantity()
        );
    }
}
