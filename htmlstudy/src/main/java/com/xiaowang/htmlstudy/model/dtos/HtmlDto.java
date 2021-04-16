package com.xiaowang.htmlstudy.model.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HtmlDto extends PageRequestDto {

    @ApiModelProperty("知识点名称")
    private String name;

}
