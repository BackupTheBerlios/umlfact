/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-13
 */
package com.uxteam.reload.databasecreator.editpolicy;


import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.uxteam.reload.databasecreator.editpart.TableEditPart;
import com.uxteam.reload.databasecreator.model.DBBase;
import com.uxteam.reload.databasecreator.model.Table;
import com.uxteam.reload.databasecreator.model.command.DbItemCreateCommand;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-13
 */
public class SchemaLayoutEditPolicy extends LayoutEditPolicy {


    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
     */
    protected EditPolicy createChildEditPolicy(EditPart child) {
        if(child instanceof TableEditPart) return new TableNonResizableEditPolicy();
        return new NonResizableEditPolicy();
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
     */
    protected Command getCreateCommand(CreateRequest request) {
        // TODO Auto-generated method stub
        Object obj = request.getNewObject();
        if(obj != null && request.getNewObjectType() == Table.class){
            DbItemCreateCommand command = new DbItemCreateCommand();
            command.setParent((DBBase)this.getHost().getModel());
            command.setChild((DBBase)obj);
            ((Table)obj).setLocation(request.getLocation());
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
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(org.eclipse.gef.Request)
     */
    protected Command getMoveChildrenCommand(Request request) {
        // TODO Auto-generated method stub
        return null;
    }

}
