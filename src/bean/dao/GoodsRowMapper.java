package bean.dao;

import bean.vo.GoodsVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsRowMapper implements RowMapper<GoodsVo> {

    @Override
    public GoodsVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        GoodsVo g=new GoodsVo();
        g.setGoodsId(rs.getString("goodsid"));
        g.setGoodsName(rs.getString("goodsname"));
        g.setPrice(rs.getFloat("price"));

        return g;



    }
}
