package com.xiaowang.htmlstudy.common.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponseResult extends ResponseResult{
    private int currentPage;
    private int size;
    private int total;

    public PageResponseResult(int currentPage, int size, int total) {
        this.currentPage = currentPage;
        this.size = size;
        this.total = total;
    }
}
