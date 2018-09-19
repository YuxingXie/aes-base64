package hello;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
    private int code;
    private String message;
    private String reasonPhrase;
    private boolean success;


    public ResponseMessage(HttpStatus httpStatus,String message) {
        this.code = httpStatus.value();
        this.success=!httpStatus.isError();
        this.reasonPhrase=httpStatus.getReasonPhrase();
        this.message=message;
    }
    public ResponseMessage(HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.success=!httpStatus.isError();
        this.reasonPhrase=httpStatus.getReasonPhrase();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
