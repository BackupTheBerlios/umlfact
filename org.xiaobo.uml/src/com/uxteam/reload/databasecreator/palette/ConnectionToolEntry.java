/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-4
 *
 */
package com.uxteam.reload.databasecreator.palette;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.tools.ConnectionCreationTool;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-4
 */
public class ConnectionToolEntry extends CreationToolEntry {

    public ConnectionToolEntry() {
        super("connection", "create connection", null, null, null);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.palette.ToolEntry#createTool()
     */
    public Tool createTool() {
        // TODO Auto-generated method stub
        return new ConnectionCreationTool(factory);
    }
}
