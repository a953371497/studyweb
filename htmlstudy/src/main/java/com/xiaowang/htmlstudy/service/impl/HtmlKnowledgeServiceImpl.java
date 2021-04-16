package com.xiaowang.htmlstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.xiaowang.htmlstudy.common.enums.AppHttpCodeEnum;
import com.xiaowang.htmlstudy.common.resp.PageResponseResult;
import com.xiaowang.htmlstudy.common.resp.ResponseResult;
import com.xiaowang.htmlstudy.dao.HtmlMapper;
import com.xiaowang.htmlstudy.model.dtos.HtmlDto;
import com.xiaowang.htmlstudy.model.pojos.HtmlPojo;
import com.xiaowang.htmlstudy.service.HtmlKnowledgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HtmlKnowledgeServiceImpl extends ServiceImpl<HtmlMapper, HtmlPojo> implements HtmlKnowledgeService {

    @Transactional
    @Override
    public ResponseResult insert(HtmlPojo htmlPojo) {
        if (null == htmlPojo) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        save(htmlPojo);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult batchQuery(HtmlDto htmlDto) {
        if (null == htmlDto) {
            return ResponseResult.okResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        htmlDto.checkParam();

        Page page = new Page(htmlDto.getPage(), htmlDto.getSize());
        LambdaQueryWrapper<HtmlPojo> wrapper = new LambdaQueryWrapper<>();
        if (!Strings.isNullOrEmpty(htmlDto.getName())) {
            wrapper.like(HtmlPojo::getName, htmlDto.getName());
        }
        IPage resultPage = page(page, wrapper);
        ResponseResult responseResult = new PageResponseResult(htmlDto.getPage(),htmlDto.getSize(),(int)resultPage.getTotal());
        responseResult.setData(resultPage.getRecords());
        return responseResult;
    }

    @Transactional
    @Override
    public ResponseResult delete(int id) {
        HtmlPojo htmlPojo = findById(id);
        if (null == htmlPojo) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public HtmlPojo findById(int id) {
        HtmlPojo htmlPojo = getById(id);
        return htmlPojo;
    }

    @Override
    public ResponseResult update(HtmlPojo htmlPojo) {
        if (null == htmlPojo) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        updateById(htmlPojo);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
