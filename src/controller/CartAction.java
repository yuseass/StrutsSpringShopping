package controller;

import bean.Item;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import service.CartService;


import javax.annotation.Resource;
import java.util.ArrayList;
@Controller
public class CartAction extends ActionSupport{

    @Resource(name="cartService")
    CartService cartService;



    private String action;
    private String quantity;
    private String goodsId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }


    public String addToCart(){


        String goodsId = this.getGoodsId();


        ArrayList<Item> cart = (ArrayList<Item>)ActionContext.getContext().getSession().get("cart");
        if(cart != null){
            cartService.setCart(cart);
            cartService.addToCart(goodsId, 1);
        }else{
            cart = new ArrayList<Item>();
            cartService.setCart(cart);
            cartService.addToCart(goodsId, 1);
        }
        ActionContext.getContext().getSession().put("cart", cartService.getCart());



        return SUCCESS;

    }




    public String modifyGoods(){
//		System.out.println(goodsId);

        int quantity = Integer.parseInt(this.getQuantity());
        String goodsId = this.getGoodsId();

        ArrayList<Item> cart = (ArrayList<Item>)ActionContext.getContext().getSession().remove("cart");

        cartService.setCart(cart);
        cartService.update(goodsId, quantity);


        ActionContext.getContext().getSession().put("cart", cartService.getCart());


        return SUCCESS;
    }


    public String clearCart(){

        ActionContext.getContext().getSession().remove("cart");

        return SUCCESS;

    }

    public String delete(){

        String goodsId = this.getGoodsId();

        ArrayList<Item> cart = (ArrayList<Item>)ActionContext.getContext().getSession().remove("cart");
        cartService.setCart(cart);
        cartService.delete(goodsId);

        ActionContext.getContext().getSession().put("cart", cartService.getCart());

        return SUCCESS;

    }





}
