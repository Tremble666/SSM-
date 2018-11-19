package cn.wolfcode.query;

import lombok.Getter;

import java.util.List;

@Getter
public class PageResult<T> {
    private int currentPage;
    private int pageSize;
    private List<T> data;
    private int totalCount;

    private int prevPage;
    private int nextPage;
    private int totalPage;

    public PageResult(int currentPage, int pageSize, List<T> data, int totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.data = data;
        this.totalCount = totalCount;

        this.totalPage = this.totalCount % this.pageSize == 0
                ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        this.prevPage = this.currentPage - 1 >=1 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1 : this.totalPage;
    }
}
