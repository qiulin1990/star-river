package com.cloudwalk.mapper;


import com.cloudwalk.model.MDimDay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MDimDayMapper {
    int deleteByPrimaryKey(String id);

    int insert(MDimDay record);

    int insertSelective(MDimDay record);

    MDimDay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MDimDay record);

    int updateByPrimaryKey(MDimDay record);

    MDimDay callFMDimDay(String year);

}