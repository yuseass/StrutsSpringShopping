package service.impl;


import bean.dao.GoodsDao;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GoodsService;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;


    @Override
    public List<GoodsVo> getGoodsByPage(int pageNo) {
        return  goodsDao.getGoodsByPage(pageNo);
    }

    @Override
    public GoodsVo getGoodsById(String goodsId) {
        return  goodsDao.getGoodsById(goodsId);
    }

    @Override
    public int getPageCount() {
        return goodsDao.getPageCount();
    }





    @Override
    public int addGoods(String id, String name, String price) {
        return goodsDao.addGoods(id, name, price);
    }

    @Override
    public int deleteGoods(String id) {

        return goodsDao.deleteGoods(id);
    }

    @Override
    public int updateGoods(String id, String newName, String newPrice) {
        return goodsDao.updateGoods(id, newName, newPrice);
    }

    @Override
    public GoodsVo queryGoods(String id) {
        return goodsDao.queryGoods(id);
    }
}
