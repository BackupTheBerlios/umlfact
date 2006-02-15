/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.editpart;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.uxteam.reload.databasecreator.model.DBBase;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-12
 */
public class DBEditPartBase extends AbstractGraphicalEditPart implements PropertyChangeListener{

    
    /* (non-Javadoc)
     * @see org.eclipse.gef.EditPart#activate()
     */
    public void activate() {
        if(getModel() != null && getModel() instanceof DBBase){
            ((DBBase)getModel()).addPropertyChangeListener(this);
        }
        super.activate();
    }
    
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.EditPart#deactivate()
     */
    public void deactivate() {
        if(getModel() != null && getModel() instanceof DBBase){
            ((DBBase)getModel()).removePropertyChangeListener(this);
        }
        super.deactivate();
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies() {
        // TODO Auto-generated method stub
        
    }
    
    

    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
     */
    protected List getModelChildren() {
        // TODO Auto-generated method stub
        if(getModel() instanceof DBBase){
            return ((DBBase)getModel()).getChildren();
        }
        return super.getModelChildren();
    }

    /* (non-Javadoc)
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent evt) {
       String pName = evt.getPropertyName();
       if(pName.equals(DBBase.PRO_FIGURE)){
           this.refreshVisuals();
       }
       if(pName.equals(DBBase.PRO_CHILD)){
           this.refreshChildren();
           this.refreshVisuals();
       }
    }
}
