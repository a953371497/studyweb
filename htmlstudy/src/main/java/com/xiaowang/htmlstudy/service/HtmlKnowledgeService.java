package com.xiaowang.htmlstudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaowang.htmlstudy.common.resp.ResponseResult;
import com.xiaowang.htmlstudy.model.dtos.HtmlDto;
import com.xiaowang.htmlstudy.model.pojos.HtmlPojo;

public interface HtmlKnowledgeService extends IService<HtmlPojo> {

    ResponseResult insert(HtmlPojo htmlPojo);

    ResponseResult batchQuery(HtmlDto htmlDto);

    ResponseResult delete(int id);

    HtmlPojo findById(int id);

    ResponseResult update(HtmlPojo htmlPojo);
}
