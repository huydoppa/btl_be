package com.example.demo.payload;

public class ApiResponse {
    private int error;
    private String msg;

    public ApiResponse() {
    }

    public ApiResponse(int error) {
        this.error = error;
    }

    public ApiResponse(int error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
