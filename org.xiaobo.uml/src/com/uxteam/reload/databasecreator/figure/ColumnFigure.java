/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-28
 *
 */
package com.uxteam.reload.databasecreator.figure;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.resource.ImageProvider;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-28
 */
public class ColumnFigure extends Label {
    private Column model;
    private boolean selected;
    private boolean hasFocus;
      public ColumnFigure(Column model){
          super();
          this.model = model;
          model.setColumnName(model.getColumnName());
          
          FontData fd = new FontData();
          
	  	  fd.setHeight(8);
			fd.setName("Arial");
			fd.setStyle(SWT.BOLD);
          this.setIcon(ImageProvider.COLUMN_ICON.createImage());
          this.setLabelAlignment(PositionConstants.LEFT);
          this.setFont(new Font(null,fd));
      }
      
      
    /* (non-Javadoc)
     * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    protected void paintFigure(Graphics graphics) {
        // TODO Auto-generated method stub
        this.setText(model.getColumnName());
    	if (selected) {
    		graphics.pushState();
    		graphics.setBackgroundColor(ColorConstants.menuBackgroundSelected);
    		graphics.fillRectangle(getSelectionRectangle());
    		graphics.popState();
    		graphics.setForegroundColor(ColorConstants.white);
    	}
    	if (hasFocus) {
    		graphics.pushState();
    		graphics.setXORMode(true);
    		graphics.setForegroundColor(ColorConstants.menuBackgroundSelected);
    		graphics.setBackgroundColor(ColorConstants.white);
    		graphics.drawFocus(getSelectionRectangle().resize(-1, -1));
    		graphics.popState();
    	}
        super.paintFigure(graphics);
    }
    
    private Rectangle getSelectionRectangle() {
    	Rectangle bounds = getTextBounds();
    	bounds.expand(new Insets(2,2,0,0));
    	translateToParent(bounds);
    	bounds.intersect(getBounds());
    	return bounds;
    }
    
    /**
     * Sets the selection state of this SimpleActivityLabel
     * @param b true will cause the label to appear selected
     */
    public void setSelected(boolean b) {
    	selected = b;
    	repaint();
    }

    /**
     * Sets the focus state of this SimpleActivityLabel
     * @param b true will cause a focus rectangle to be drawn around the text of the Label
     */
    public void setFocus(boolean b) {
    	hasFocus = b;
    	repaint();
    }
}
