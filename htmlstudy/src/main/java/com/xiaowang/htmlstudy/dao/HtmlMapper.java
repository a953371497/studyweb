package com.xiaowang.htmlstudy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaowang.htmlstudy.model.pojos.HtmlPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HtmlMapper extends BaseMapper<HtmlPojo> {
}
