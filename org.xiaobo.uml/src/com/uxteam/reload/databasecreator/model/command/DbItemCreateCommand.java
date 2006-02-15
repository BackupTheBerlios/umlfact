/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.model.command;


import org.eclipse.core.internal.runtime.Assert;
import org.eclipse.gef.commands.Command;

import com.uxteam.reload.databasecreator.model.DBBase;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-3
 */
public class DbItemCreateCommand extends Command {
    private DBBase parent;
    private DBBase child;
    private int index = -1;
    
    
    /* (non-Javadoc)
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute() {
        Assert.isNotNull(parent);
        Assert.isNotNull(child);
        parent.addChild(index,child);
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo() {
        execute();
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo() {
        Assert.isNotNull(parent);
        Assert.isNotNull(child);
        parent.removeChild(child);
    }
    /**
     * @return 返回 parent.
     */
    public DBBase getParent() {
        return parent;
    }
    /**
     * @param parent 设置 parent 
     */
    public void setParent(DBBase parent) {
        this.parent = parent;
    }
    /**
     * @return 返回 child.
     */
    public DBBase getChild() {
        return child;
    }
    /**
     * @param child 设置 child 
     */
    public void setChild(DBBase child) {
        this.child = child;
    }
    /**
     * @return 返回 index.
     */
    public int getIndex() {
        return index;
    }
    /**
     * @param index 设置 index 
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
