/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
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
 * ���� �� 
 * ����ʱ�䣺2005-9-3
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
     * @return ���� parent.
     */
    public DBBase getParent() {
        return parent;
    }
    /**
     * @param parent ���� parent 
     */
    public void setParent(DBBase parent) {
        this.parent = parent;
    }
    /**
     * @return ���� child.
     */
    public DBBase getChild() {
        return child;
    }
    /**
     * @param child ���� child 
     */
    public void setChild(DBBase child) {
        this.child = child;
    }
    /**
     * @return ���� index.
     */
    public int getIndex() {
        return index;
    }
    /**
     * @param index ���� index 
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
