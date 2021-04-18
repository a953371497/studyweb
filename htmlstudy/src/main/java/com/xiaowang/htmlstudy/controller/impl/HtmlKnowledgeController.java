package com.xiaowang.htmlstudy.controller.impl;

import com.xiaowang.htmlstudy.common.resp.ResponseResult;
import com.xiaowang.htmlstudy.controller.HtmlKnowledgeControllerApi;
import com.xiaowang.htmlstudy.model.dtos.HtmlDto;
import com.xiaowang.htmlstudy.model.pojos.HtmlPojo;
import com.xiaowang.htmlstudy.service.HtmlKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/html")
public class HtmlKnowledgeController implements HtmlKnowledgeControllerApi {

    @Autowired
    private HtmlKnowledgeService htmlKnowledgeService;

    @PostMapping("/insert")
    @Override
    public ResponseResult insert(@RequestBody HtmlPojo htmlPojo) {
        return htmlKnowledgeService.insert(htmlPojo);
    }

    @PostMapping("/batchQuery")
    @Override
    public ResponseResult batchQuery(@RequestBody HtmlDto htmlDto) {
        return htmlKnowledgeService.batchQuery(htmlDto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseResult delete(@PathVariable("id") int id) {
        return htmlKnowledgeService.delete(id);
    }

    @GetMapping("/one/{id}")
    @Override
    public HtmlPojo queryById(@PathVariable("id") int id) {
        return htmlKnowledgeService.getById(id);
    }

    @PutMapping("/update")
    @Override
    public ResponseResult update(@RequestBody HtmlPojo htmlPojo) {
        return htmlKnowledgeService.update(htmlPojo);
    }
}
