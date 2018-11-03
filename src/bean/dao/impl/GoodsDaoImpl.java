package bean.dao.impl;

import java.util.List;

import bean.dao.GoodsDao;
import bean.dao.GoodsRowMapper;
import bean.vo.GoodsVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {


	JdbcTemplate jdbcTemplate;

	DataSource dataSource;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}




	public List<GoodsVo> getGoodsByPage(int pageNo){
		int numPerPage = 2;
		int begin = (pageNo - 1)*numPerPage;
        int end=pageNo*2;

		String sql = "select * from goods limit "+begin+","+numPerPage;
		List<GoodsVo> rst=jdbcTemplate.query(sql,new GoodsRowMapper());

		return rst;
	}
	
	
	public GoodsVo getGoodsById(String goodsId){

		String sql = "select * from goods where goodsid=?";
        GoodsVo g=jdbcTemplate.queryForObject(sql,new Object[]{goodsId},
                new int[]{java.sql.Types.INTEGER},new GoodsRowMapper());
		
		return g;
	}

	public int getPageCount(){

        String sql="select * from goods";
        List<GoodsVo> rst=jdbcTemplate.query(sql,new GoodsRowMapper());
        int num=rst.size();
		return (num-1)/2+1;
		
	}



    @Override
    public int addGoods(String id, String name, String price) {
        GoodsVo g=new GoodsVo();
        g.setGoodsId(id);
        g.setGoodsName(name);
        g.setPrice(Float.parseFloat(price));

        String sql = "insert into goods(goodsid,goodsname,price)values(?,?,?)";
        int rs=jdbcTemplate.update(sql,
                new Object[]{g.getGoodsId(),g.getGoodsName(),g.getPrice()});

	    return rs;
    }

    @Override
    public int deleteGoods(String id) {
        String sql = "delete from goods where goodsid = ?";

        int rs=jdbcTemplate.update(sql,
                new Object[]{id});

        return rs;
    }

    @Override
    public int updateGoods(String id, String newName, String newPrice) {
        String sql = "update goods set goodsname = ? , price = ? where goodsid = ?";

        int rs=jdbcTemplate.update(sql,
                new Object[]{newName,newPrice,id});

        return rs;
    }

    @Override
    public GoodsVo queryGoods(String id) {

	    return this.getGoodsById(id);
    }


}
