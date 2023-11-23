package kk_framework.handler.exception;


import kk_framework.enums.AppHttpCodeEnum;
import kk_framework.exception.SystemException;
import kk_framework.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHander {


    @ExceptionHandler({SystemException.class})
    public ResponseResult systemExceptionHandler(SystemException e){
        //打印异常信息

        log.error("出现了异常! {}",e);

        //从异常对象中获取提示信息，封装返回
        return ResponseResult.errorResult(e.getCode(),e.getMsg());
    }

    @ExceptionHandler({Exception.class})
    public ResponseResult ExceptionHandler(Exception e){
        //打印异常信息

        log.error("出现了异常! {}",e);

        //从异常对象中获取提示信息，封装返回
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),e.getMessage());
    }
}
