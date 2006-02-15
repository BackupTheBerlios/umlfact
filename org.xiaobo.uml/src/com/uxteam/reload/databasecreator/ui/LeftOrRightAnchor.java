/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-4
 *
 */
package com.uxteam.reload.databasecreator.ui;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-4
 */
public class LeftOrRightAnchor extends ChopboxAnchor {
	public LeftOrRightAnchor(IFigure owner) {
		super(owner);
	}
	public Point getLocation(Point reference) {
		Point p;
		p = getOwner().getBounds().getCenter();
		getOwner().translateToAbsolute(p);
		if (reference.x < p.x){
			p = getOwner().getBounds().getLeft();
			p.x -= 8;
		}
		else{
			p = getOwner().getBounds().getRight();
			p.x += 8;
		}
		getOwner().translateToAbsolute(p);
		return p;
	}
}

