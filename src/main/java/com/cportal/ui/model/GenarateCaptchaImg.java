package com.cportal.ui.model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

public class GenarateCaptchaImg {
	private String path;
	private String fileName;
	//public static void main(String arg[]) throws IOException {
    public  String generateImg(String key1) throws IOException {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String key = key1;

        BufferedImage bufferedImage = new BufferedImage(90, 20,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        Color c = new Color(238,238,238);
        graphics.setColor(c);
        graphics.fillRect(0, 0, 200, 50);
        graphics.setColor(Color.DARK_GRAY);
        graphics.setFont(new Font("Arial Black", Font.ITALIC, 20));
        graphics.drawString(key, 10, 17);
        path="/tmp/captcha_img";
         fileName= uuid.substring(6, 15)+".png";
        File files = new File(path);
    	if (!files.exists()) {
    		if (files.mkdirs()) {
    			System.out.println("Multiple directories are created!");
    		} else {
    			System.out.println("Failed to create multiple directories!");
    		}
    	}
        ImageIO.write(bufferedImage, "jpg", new File(path+"/"+fileName));

        return path+"/"+fileName;
    }
    
   
}