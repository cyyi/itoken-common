package com.aaron.itoken.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResult implements Serializable {
    public static final String RESULT_OK = "ok";
    public static final String RESULT_NOT_OK = "not_ok";
    public static final String SUCCESS = "成功操作";

    private String result;
    private Object data;
    private Cursor cursor;
    private String success;
    private List<Error> errors;

    public static BaseResult ok() {
        return createResult(RESULT_OK,null,null,SUCCESS,null);
    }

    public static BaseResult ok(Object data) {
        return createResult(RESULT_OK,data,null,SUCCESS,null);
    }

    public static BaseResult not_ok(List<Error> errors){
        return createResult(RESULT_NOT_OK,null,null,"",errors);
    }

    private static BaseResult createResult(String result, Object data, Cursor cursor, String success, List<Error> errors) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setCursor(cursor);
        baseResult.setSuccess(success);
        baseResult.setErrors(errors);
        return baseResult;
    }

    @Data
    @AllArgsConstructor
    public static class Cursor {
        private int total;
        private int offset;
        private int limit;
    }

    @Data
    @AllArgsConstructor
    public static class Error {
        private String field;
        private String message;
    }
}
