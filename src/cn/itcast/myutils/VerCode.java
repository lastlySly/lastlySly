package cn.itcast.myutils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerCode {
    public static VerificationCode Vercode() throws Exception{
        int width = 120;
        int height = 30;
        // 在内存中生成图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 先获取画笔对象
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        // 画填充的矩形
        g.fillRect(0, 0, width, height);
        // 设置颜色
        g.setColor(Color.BLUE);
        // 画边框
        g.drawRect(0, 0, width-1, height-1);
        // 准备数据，随机获取4个字符
        String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        // 设置颜色
        g.setColor(Color.RED);
        // 设置字体
        g.setFont(new Font("隶书", Font.BOLD, 20));

        StringBuffer strbuf = new StringBuffer();

        Random random = new Random();
        int x = 20;
        int y = 20;
        for(int i=0;i<4;i++){
            int jiaodu = random.nextInt(60)-30;
            double hudu = jiaodu * Math.PI / 180;
            g.rotate(hudu, x, y);
            // 获取下标
            int index = random.nextInt(words.length());
            // 返回指定下标位置的字符，随机获取下标
            char ch = words.charAt(index);
            // 写字符串

            strbuf.append(ch);

            g.drawString(""+ch, x, y);
            g.rotate(-hudu, x, y);
            x += 20;
        }

        String codestr = strbuf.toString();

        g.setColor(Color.GREEN);
        int x1,x2,y1,y2;
        // 画干扰线
        for(int i=0;i<4;i++){
            x1 = random.nextInt(width);
            y1 = random.nextInt(height);
            x2 = random.nextInt(width);
            y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        VerificationCode vercode = new VerificationCode(image, codestr);
        return vercode;
    }
}
