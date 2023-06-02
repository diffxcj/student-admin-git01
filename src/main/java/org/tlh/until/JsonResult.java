package org.tlh.until;

import lombok.Data;

@Data
public class JsonResult {
    private boolean success=true;
    private  String msg="操作成功";
    public JsonResult() {

    }
    public JsonResult(boolean success,String msg) {
        this.success = success;
        this.msg = msg;

    }
}
