/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.editpart;


import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.graphics.Color;

import com.uxteam.reload.databasecreator.editpolicy.SchemaLayoutEditPolicy;

/**
 * @author <b>彭雪</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-12
 */
public class SchemaEditPart extends DBEditPartBase {

    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure() {
        IFigure figure = new FreeformLayer(){
			public void paintFigure(Graphics g){
				super.paintFigure(g);
				g.setBackgroundColor(new Color(null,253,250,240));
				g.fillRectangle(getBounds());
			}
        };
        figure.setLayoutManager(new FreeformLayout());
        return figure;
    }
    
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies() {
        this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new SchemaLayoutEditPolicy());
    }
}
