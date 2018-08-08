package com.xgj.demo.mapper;

import com.xgj.demo.model.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AreaMapper {
    int deleteByPrimaryKey(String id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> selectAllAccount();

    void insertAllArea(@Param("vo") Area area);
}