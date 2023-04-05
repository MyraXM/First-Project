package cn.wolfcode.lww.util;

import lombok.ToString;

@ToString
public class QueryObject {
    private int currentPage = 1;    //默认的当前页是第一页

    private int pageSize = 4;       //默认每页显示的数据为5条

    //提供一个方法,用于返回每页第一条数据对应的索引
    public int getStart(){
        //显而易见,第一页第一条数据的索引为0,即索引为0,1,2,3,4的五条
        //第二页第一条的数据索引为5,即5,6,7,8,9这五条
        return (currentPage - 1)*pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}