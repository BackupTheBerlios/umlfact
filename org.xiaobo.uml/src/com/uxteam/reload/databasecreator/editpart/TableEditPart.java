/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.editpart;


import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;

import com.uxteam.reload.databasecreator.editpolicy.TableFlowLayoutEditPolicy;
import com.uxteam.reload.databasecreator.figure.TableFigure;
import com.uxteam.reload.databasecreator.model.Table;

/**
 * @author <b>彭雪 </b>
 * 
 * 描述 ： 创建时间：2005-8-12
 */
public class TableEditPart extends DBEditPartBase {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure() {
        // 返回Table的Figure
        return new TableFigure((Table)this.getModel());
    }
    
    

    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies() {
        // TODO Auto-generated method stub
        super.createEditPolicies();
        this.installEditPolicy(EditPolicy.CONTAINER_ROLE,new TableFlowLayoutEditPolicy());
    }
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#registerVisuals()
     */
    protected void refreshVisuals() {
        super.refreshVisuals();
        // 得到当前TableFigure的大小,由于有Toolbar布局的约束，它会自动计算
       
        Dimension size = this.getFigure().getPreferredSize();
        
        // 获得更改后的位置,位置是在Model进行维护的
        Point p = ((Table) getModel()).getLocation();
        
        // 我们只更改Table的位置
        ((GraphicalEditPart) this.getParent()).setLayoutConstraint(this, this
                .getFigure(),new Rectangle(p, size));
    }
    
    
    /**
     * 设置EditPart的容器Figure为TableFigure的ContainerFigure
     */
    public IFigure getContentPane() {
        return ((TableFigure)getFigure()).getContainerFigure();
    }
}