/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-4
 *
 */
package com.uxteam.reload.databasecreator.editpolicy;


import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.model.command.CreateConnectionCommand;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-4
 */
public class ColumnNodeEditPolicy extends GraphicalNodeEditPolicy {

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
     */
    protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
        CreateConnectionCommand command = (CreateConnectionCommand)request.getStartCommand();
        if(command == null) return null;
        command.setTarget((Column)getHost().getModel());
        
        return command;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
     */
    protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
        CreateConnectionCommand command = new CreateConnectionCommand();
        command.setSource((Column)getHost().getModel());
        request.setStartCommand(command);
        return command;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
     */
    protected Command getReconnectTargetCommand(ReconnectRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
     */
    protected Command getReconnectSourceCommand(ReconnectRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
