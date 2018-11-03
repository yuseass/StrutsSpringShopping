package service;

import bean.vo.GoodsVo;

import java.util.List;

public interface GoodsService {
    public List<GoodsVo> getGoodsByPage(int pageNo);
    public GoodsVo getGoodsById(String goodsId);
    public int getPageCount();

    //实验2内容
    public int addGoods(String id,String name,String price);
    public int deleteGoods(String id);
    public int updateGoods(String id,String newName,String newPrice);
    public GoodsVo queryGoods(String id);



}
