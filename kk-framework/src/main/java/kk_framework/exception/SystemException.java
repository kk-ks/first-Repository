package kk_framework.exception;

import kk_framework.enums.AppHttpCodeEnum;

public class SystemException  extends RuntimeException{
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum){
        super(httpCodeEnum.getMsg());
        this.code=httpCodeEnum.getCode();
        this.msg=httpCodeEnum.getMsg();
    }
}
