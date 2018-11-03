package service;

import bean.Item;

import java.util.ArrayList;

public interface CartService {
    public void addToCart(String goodsId, int quantity);
    public void update(String goodsId, int quantity);
    public void delete(String goodsId);

    void setCart(ArrayList<Item> cart);

    Object getCart();
}
