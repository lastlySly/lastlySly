package cn.itcast.myutils;

public class MyResponseJson {
    private int code;
    private String tip;
    private Object data;

    public MyResponseJson() {
    }
    public MyResponseJson(int code, String tip, Object data) {
        this.code = code;
        this.tip = tip;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
