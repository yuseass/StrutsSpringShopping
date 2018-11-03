package service.impl;

import bean.Item;
import bean.dao.GoodsDao;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CartService;

import java.util.ArrayList;
import java.util.Iterator;

@Service("cartService")
public class CartServiceImpl implements CartService {

    ArrayList<Item> cart = new ArrayList<Item>();
    @Autowired
    GoodsDao goodsDao;

    @Override
    public void addToCart(String goodsId, int quantity) {

        GoodsVo g = goodsDao.getGoodsById(goodsId);

        Iterator<Item> it = cart.iterator();
        boolean find = false;
        while(it.hasNext()){
            Item oneItem = it.next();
            if(oneItem.getGoods().getGoodsId().equalsIgnoreCase(goodsId)){
                oneItem.setQuantity(oneItem.getQuantity() + quantity);
                find = true;
            }
        }
        if(!find){
            Item newItem = new Item(g,quantity);
            cart.add(newItem);
        }
    }

    @Override
    public void update(String goodsId, int quantity) {

        Iterator<Item> it = cart.iterator();
        while(it.hasNext()){
            Item oneItem = it.next();
            if(oneItem.getGoods().getGoodsId().equalsIgnoreCase(goodsId)){
                oneItem.setQuantity(quantity);
                break;
            }
        }

    }

    @Override
    public void delete(String goodsId) {
        if(cart != null){
            Iterator it = cart.iterator();
            while(it.hasNext()){
                Item temp = (Item)it.next();
                String tGoodsId = temp.getGoods().getGoodsId();

                if(tGoodsId.equals(goodsId)){
                    cart.remove(temp);
                    break;
                }

            }//while

        }//if
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
}
