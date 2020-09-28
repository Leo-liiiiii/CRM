package com.ujiuye.util;

//回传给前端页面后台处理的结果
public class ResultInfo {
    //标记类
    private boolean  flag;
    private String  othermsg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getOthermsg() {
        return othermsg;
    }

    public void setOthermsg(String othermsg) {
        this.othermsg = othermsg;
    }
}
