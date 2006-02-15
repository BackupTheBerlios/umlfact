/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
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
 * ���� �� 
 * ����ʱ�䣺2005-9-4
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
     * @return ���� source.
     */
    public Column getSource() {
        return source;
    }
    /**
     * @param source ���� source 
     */
    public void setSource(Column source) {
        this.source = source;
    }
    /**
     * @return ���� targe.
     */
    public Column getTarget() {
        return target;
    }
    /**
     * @param targe ���� targe 
     */
    public void setTarget(Column targe) {
        this.target = targe;
    }
}
