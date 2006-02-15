/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.editpolicy;


import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.uxteam.reload.databasecreator.editpart.ColumnEditPart;
import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.model.DBBase;
import com.uxteam.reload.databasecreator.model.command.DbItemCreateCommand;

/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-9-3
 */
public class TableFlowLayoutEditPolicy extends FlowLayoutEditPolicy {

    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
     */
    protected EditPolicy createChildEditPolicy(EditPart child) {
        if(child instanceof ColumnEditPart)
            return new ColumnSelectionEditPolicy();
        return super.createChildEditPolicy(child);
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart, org.eclipse.gef.EditPart)
     */
    protected Command createAddCommand(EditPart child, EditPart after) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createMoveChildCommand(org.eclipse.gef.EditPart, org.eclipse.gef.EditPart)
     */
    protected Command createMoveChildCommand(EditPart child, EditPart after) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
     */
    protected Command getCreateCommand(CreateRequest request) {
        Object obj = request.getNewObject();
        if(obj != null && request.getNewObjectType() == Column.class){
            DbItemCreateCommand command = new DbItemCreateCommand();
            command.setParent((DBBase)this.getHost().getModel());
            command.setChild((DBBase)obj);
            
            EditPart after = getInsertionReference(request);
            int index = getHost().getChildren().indexOf(after);
            command.setIndex(index);
            return command;
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
     */
    protected Command getDeleteDependantCommand(Request request) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.FlowLayoutEditPolicy#isHorizontal()
     */
    protected boolean isHorizontal() {
        IFigure figure = ((GraphicalEditPart)getHost()).getContentPane();
        LayoutManager layout = figure.getLayoutManager();
        if(layout instanceof FlowLayout)
    	return ((FlowLayout)figure.getLayoutManager()).isHorizontal();
        if(layout instanceof ToolbarLayout)
        	return ((ToolbarLayout)figure.getLayoutManager()).isHorizontal();
        return false;
    }
}
