package com.frkblacksea.customertrigger.model;

public class ApiResponse {
    private int statusCode;
    private String message;
    private Object body;

    public ApiResponse() {
    }

    public ApiResponse(int statusCode, String message, Object body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public ApiResponse(ApiResponseBuilder builder) {
        this.statusCode = builder.statusCode;
        this.message = builder.message;
        this.body = builder.body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public static class ApiResponseBuilder {
        private int statusCode;
        private String message;
        private Object body;

        public ApiResponse build() {
            return new ApiResponse(this);
        }

        public ApiResponseBuilder setStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ApiResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder setBody(Object body) {
            this.body = body;
            return this;
        }
    }
}
