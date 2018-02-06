package cn.itcast.myutils;

import java.awt.image.BufferedImage;

public class VerificationCode {
    private BufferedImage img;
    private String str;

    public VerificationCode(BufferedImage img, String str) {
        this.img = img;
        this.str = str;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
