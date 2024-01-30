package com.example.blessingchess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blessingchess.data.po.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper extends BaseMapper<Test> {

}
