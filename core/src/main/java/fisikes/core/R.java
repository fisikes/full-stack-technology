package fisikes.core;

import java.util.Objects;

/**
 * R的泛型版本
 */
public class R<T> {

    private final static Integer SUCCESS = 0;
    private final static Integer FAIL = -1;
    private final static Integer WARN = 1;

    private T data;

    private Integer code;

    private String message;

    private String detail;

    public R(T data, Integer code, String message, String detail) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public Boolean succeed() {
        return Objects.equals(this.code, SUCCESS);
    }

    public Boolean failed() {
        return !Objects.equals(this.code, SUCCESS);
    }

    public static <T> R<T> success(T data) {
        return new R<>(data, SUCCESS, "成功", null);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(null, FAIL, msg, null);
    }

    public static R fail() {
        return new R<>(null, FAIL, "失败", null);
    }

    public void setData(T data) {
        this.data = data;
    }

    public static R fail(String msg, String detail) {
        return new R<>(null, FAIL, msg, detail);
    }


    public T getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "GenericR{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
