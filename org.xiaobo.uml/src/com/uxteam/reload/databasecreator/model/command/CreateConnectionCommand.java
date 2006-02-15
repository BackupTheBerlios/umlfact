/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-4
 *
 */
package com.uxteam.reload.databasecreator.model.command;


import org.eclipse.gef.commands.Command;

import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.model.Connection;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-4
 */
public class CreateConnectionCommand extends Command {

    private Column source;
    private Column target;
    /* (non-Javadoc)
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute() {
        new Connection(source,target);
    }
    /**
     * @return 返回 source.
     */
    public Column getSource() {
        return source;
    }
    /**
     * @param source 设置 source 
     */
    public void setSource(Column source) {
        this.source = source;
    }
    /**
     * @return 返回 targe.
     */
    public Column getTarget() {
        return target;
    }
    /**
     * @param targe 设置 targe 
     */
    public void setTarget(Column targe) {
        this.target = targe;
    }
}
