/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.graphics.util;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-3
 */
public class GraphicsUtil {
    private GraphicsUtil(){}
    public static final Color OrangeColor = new Color(null,254,142,18);
    public static void paintPlusArea(Graphics g,Point position,Dimension dimension){
        g.pushState();
        int speed = 2;
        Color base = g.getForegroundColor();
        int green = base.getGreen();
        int blue = base.getBlue();
        int red = base.getRed();
        int redp = (255 - red)/dimension.height + speed;
        int bluep = (255 - blue)/dimension.height + speed;
        int greenp = (255 - green)/dimension.height + speed;
        for(int i = 0;i<dimension.height ; i++){
            red +=redp ;
            green+=greenp;
            blue+=bluep;
            if(red > 255)  red = 255;
            if(green > 255)  green = 255;
            if(blue > 255)  blue = 255;
            g.setForegroundColor(new Color(null,red,green,blue));
            g.drawLine(position.x,position.y + i,position.x + dimension.width,position.y + i);
        }
        g.popState();
    }
}
