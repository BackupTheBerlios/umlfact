/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-13
 *
 */
package com.uxteam.reload.databasecreator.editpolicy;


import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

import com.uxteam.reload.databasecreator.model.Table;
import com.uxteam.reload.databasecreator.model.command.TableMoveCommand;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-13
 */
public class TableNonResizableEditPolicy extends NonResizableEditPolicy {

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#getMoveCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
     */
    protected Command getMoveCommand(ChangeBoundsRequest request) {
        // TODO Auto-generated method stub
        TableMoveCommand command = new TableMoveCommand();
        command.setModel((Table)getHost().getModel());
        command.setRequest(request);
        return command;
    }
}
