package com.xiaowang.htmlstudy.controller;

import com.xiaowang.htmlstudy.common.resp.ResponseResult;
import com.xiaowang.htmlstudy.model.dtos.HtmlDto;
import com.xiaowang.htmlstudy.model.pojos.HtmlPojo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "html知识点接口")
public interface HtmlKnowledgeControllerApi {

    @ApiOperation(value = "新增数据")
    ResponseResult insert(HtmlPojo htmlPojo);

    @ApiOperation(value = "模糊查询/分页查询")
    ResponseResult batchQuery(HtmlDto htmlDto);

    @ApiOperation(value = "根据id删除")
    ResponseResult delete(int id);

    @ApiOperation(value = "根据id查询详情")
    HtmlPojo queryById(int id);

    @ApiOperation(value = "编辑知识点信息")
    ResponseResult update(HtmlPojo htmlPojo);
}
