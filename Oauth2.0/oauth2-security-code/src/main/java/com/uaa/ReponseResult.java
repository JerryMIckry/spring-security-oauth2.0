package com.uaa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Yusentong
 * @Date: 2020/6/2 19:00
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReponseResult {

    //返回状态码
    private String code;

    //返回信息
    private String msg;

    //返回数据
    private Object data;

    public ReponseResult(Object data) {
        this.code = "200";
        this.msg = "操作成功！";
        this.data = data;
    }

    public ReponseResult(String msg, Object data) {
        this.code = "200";
        this.msg = msg;
        this.data = data;
    }

    public ReponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }


}
