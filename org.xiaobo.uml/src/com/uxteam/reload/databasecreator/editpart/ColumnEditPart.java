/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.editpart;


import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

import com.uxteam.reload.databasecreator.editpolicy.ColumnNodeEditPolicy;
import com.uxteam.reload.databasecreator.figure.ColumnFigure;
import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.model.DBBase;
import com.uxteam.reload.databasecreator.ui.LeftOrRightAnchor;

/**
 * @author <b>彭雪</b>
 *
 * 描述 ： 
 * 创建时间：2005-8-12
 */
public class ColumnEditPart extends DBEditPartBase implements NodeEditPart{

    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure() {
        // TODO Auto-generated method stub
        return new ColumnFigure((Column)getModel());
    }

    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        // TODO Auto-generated method stub
        return new LeftOrRightAnchor(getFigure());
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        // TODO Auto-generated method stub
        return new LeftOrRightAnchor(getFigure());
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        // TODO Auto-generated method stub
        return new LeftOrRightAnchor(getFigure());
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        // TODO Auto-generated method stub
        return new EllipseAnchor(getFigure());
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.GraphicalEditPart#getSourceConnections()
     */
    public List getModelSourceConnections() {
        // TODO Auto-generated method stub
        return ((Column)getModel()).getOuts();
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.GraphicalEditPart#getTargetConnections()
     */
    public List getModelTargetConnections() {
        // TODO Auto-generated method stub
        return ((Column)getModel()).getIncomes();
    }
    
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies() {
        // TODO Auto-generated method stub
        super.createEditPolicies();
        this.installEditPolicy(EditPolicy.CONNECTION_ROLE,new ColumnNodeEditPolicy());
    }
    /* (non-Javadoc)
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        if(name.equals(DBBase.PRO_CONNECTION_IN))
            this.refreshTargetConnections();
        if(name.equals(DBBase.PRO_CONNECTION_OUT))
            this.refreshSourceConnections();
        super.propertyChange(evt);
    }
}
