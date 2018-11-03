package controller;

import bean.dao.impl.GoodsDaoImpl;
import bean.vo.GoodsVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;
import service.GoodsService;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsAction extends ActionSupport{

    @Resource(name = "goodsService")
    GoodsService goodsService;


    private String pageNo;

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageNo() {
        return pageNo;
    }


    @Override
    public String execute() throws Exception {




        String pageNo = this.getPageNo();
        int page = 1;
        if(pageNo != null){
            page = Integer.parseInt(pageNo);
        }

        List<GoodsVo> goodsList =goodsService.getGoodsByPage(page);

        int pageCount = goodsService.getPageCount();

        ActionContext.getContext().getSession().put("goodsList", goodsList);
        ActionContext.getContext().getSession().put("pageNo", page);
        ActionContext.getContext().getSession().put("pageCount", pageCount);

       return SUCCESS;


    }



    //实验二
    String id,name,price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String addGoods() {
        String id=this.id;
        String name=this.name;
        String price=this.price;

        String tips;
        if(goodsService.addGoods(id,name,price)!=0){
            tips="插入成功";
        }

        return "getAllGoods";
    }

    public String deleteGoods() {
        String id=this.id;

        goodsService.deleteGoods(id);
        return "getAllGoods";
    }

    public String updateGoods() {
        String id=this.id;
        String newName=this.name;
        String newPrice=this.price;

        goodsService.updateGoods(id, newName, newPrice);
        return "getAllGoods";
    }

    public String queryGoods() {

        String id=this.id;
        GoodsVo g=new GoodsVo();
        g=goodsService.queryGoods(id);
        List<GoodsVo> goodsList=new ArrayList<GoodsVo>();

        goodsList.add(g);

        ActionContext.getContext().getSession().put("goodsList", goodsList);
        ActionContext.getContext().getSession().put("pageNo", 1);
        ActionContext.getContext().getSession().put("pageCount", 1);

        return SUCCESS;
    }


}
