/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
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
 * @author <b>��ѩ </b>
 * 
 * ���� �� ����ʱ�䣺2005-8-12
 */
public class TableEditPart extends DBEditPartBase {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure() {
        // ����Table��Figure
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
        // �õ���ǰTableFigure�Ĵ�С,������Toolbar���ֵ�Լ���������Զ�����
       
        Dimension size = this.getFigure().getPreferredSize();
        
        // ��ø��ĺ��λ��,λ������Model����ά����
        Point p = ((Table) getModel()).getLocation();
        
        // ����ֻ����Table��λ��
        ((GraphicalEditPart) this.getParent()).setLayoutConstraint(this, this
                .getFigure(),new Rectangle(p, size));
    }
    
    
    /**
     * ����EditPart������FigureΪTableFigure��ContainerFigure
     */
    public IFigure getContentPane() {
        return ((TableFigure)getFigure()).getContainerFigure();
    }
}