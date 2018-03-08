package com.songyang.tour.dao.impl;


import com.songyang.tour.dao.SyReserveRentCarOrderDao;
import com.songyang.tour.pojo.SyReserveRentCarOrder;
import com.songyang.tour.query.SyReserveRentCarOrderQuery;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by  小工具  on 2017/11/19.
 */
@Repository
public class SyReserveRentCarOrderDaoImpl extends SqlSessionDaoSupport implements SyReserveRentCarOrderDao {


	/**
	 * mybatis mapper的命名空间，包路径加类名
	 */
	private static final String NAME_SPACE = SyReserveRentCarOrder.class.getName();


	/**
	 * 返回mybatis 执行代码语句块定位字符串，是namespace.id 组成
	 *
	 * @param id id主键
	 * @return namespace.id
	 */
    public String generateStatement(String id) {
        return NAME_SPACE.concat(".").concat(id);
    }

    public int insert(SyReserveRentCarOrder syReserveRentCarOrder) {
        Assert.notNull(syReserveRentCarOrder);
        syReserveRentCarOrder.setCreateTime(new Date());
        
        return getSqlSession().insert(generateStatement("insert"), syReserveRentCarOrder);
    }


    public int deleteById(Long id) {
        Assert.notNull(id);
        
        return getSqlSession().delete(generateStatement("deleteById"), id);
    }

    public int updateById(SyReserveRentCarOrder syReserveRentCarOrder) {
        Assert.notNull(syReserveRentCarOrder);
        Assert.notNull(syReserveRentCarOrder.getId());
        syReserveRentCarOrder.setModifyTime(new Date());

        return getSqlSession().update(generateStatement("updateById"), syReserveRentCarOrder);
    }

    public SyReserveRentCarOrder selectById(Long id) {
        Assert.notNull(id);
        
        return getSqlSession().selectOne(generateStatement("selectById"), id);
    }

    public SyReserveRentCarOrder selectByIdForUpdate(Long id) {
        Assert.notNull(id);
        
        return getSqlSession().selectOne(generateStatement("selectByIdForUpdate"), id);
    }

    public List<SyReserveRentCarOrder> queryListByParam(SyReserveRentCarOrderQuery syReserveRentCarOrderQuery) {
        Assert.notNull(syReserveRentCarOrderQuery);
        syReserveRentCarOrderQuery.checkBaseQuery(MAX_ROWS);
        
        return getSqlSession().selectList(generateStatement("queryListByParam"), syReserveRentCarOrderQuery);
    }

    public Long queryCountByParam(SyReserveRentCarOrderQuery syReserveRentCarOrderQuery) {
        Assert.notNull(syReserveRentCarOrderQuery);
        
        return getSqlSession().selectOne(generateStatement("queryCountByParam"), syReserveRentCarOrderQuery);
    }


}