package com.songyang.tour.dao.impl;


import com.songyang.tour.dao.SyHotelDao;
import com.songyang.tour.pojo.SyHotel;
import com.songyang.tour.query.SyHotelQuery;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by  小工具  on 2017/08/31.
 */
@Repository
public class SyHotelDaoImpl extends SqlSessionDaoSupport implements SyHotelDao {


    /**
     * mybatis mapper的命名空间，包路径加类名
     */
    private static final String NAME_SPACE = SyHotel.class.getName();


    /**
     * 返回mybatis 执行代码语句块定位字符串，是namespace.id 组成
     *
     * @param id id主键
     * @return namespace.id
     */
    public String generateStatement(String id) {
        return NAME_SPACE.concat(".").concat(id);
    }

    public int insert(SyHotel syHotel) {
        Assert.notNull(syHotel);
        syHotel.setCreateTime(new Date());

        return getSqlSession().insert(generateStatement("insert"), syHotel);
    }


    public int deleteById(Long id) {
        Assert.notNull(id);

        return getSqlSession().delete(generateStatement("deleteById"), id);
    }

    public int updateById(SyHotel syHotel) {
        Assert.notNull(syHotel);
        Assert.notNull(syHotel.getId());
        syHotel.setModifyTime(new Date());

        return getSqlSession().update(generateStatement("updateById"), syHotel);
    }

    public SyHotel selectById(Long id) {
        Assert.notNull(id);

        return getSqlSession().selectOne(generateStatement("selectById"), id);
    }

    public SyHotel selectByIdForUpdate(Long id) {
        Assert.notNull(id);

        return getSqlSession().selectOne(generateStatement("selectByIdForUpdate"), id);
    }

    public List<SyHotel> queryListByParam(SyHotelQuery syHotelQuery) {
        Assert.notNull(syHotelQuery);
        syHotelQuery.checkBaseQuery(MAX_ROWS);

        return getSqlSession().selectList(generateStatement("queryListByParam"), syHotelQuery);
    }

    public Long queryCountByParam(SyHotelQuery syHotelQuery) {
        Assert.notNull(syHotelQuery);

        return getSqlSession().selectOne(generateStatement("queryCountByParam"), syHotelQuery);
    }


}