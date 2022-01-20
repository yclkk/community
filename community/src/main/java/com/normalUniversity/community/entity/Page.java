package com.normalUniversity.community.entity;


/*封装分页的数据*/
public class Page {
    private int current = 1; //默认当前页数为1
    private int limit = 10; // 默认一页限制为10
    private int rows;  // 数据总数
    private String path; // 复用查询路径

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /*获得当前页的起始行*/
    public int getOffSet() {
        return current * limit - limit;
    }
    /*
    * 获取总页数*/
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }
    /*获取起始页码*/
    public int getFrom() {
        int from = current - 2;
        return from <  1 ? 1 : from;
    }


    /*获取结束页码*/
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
