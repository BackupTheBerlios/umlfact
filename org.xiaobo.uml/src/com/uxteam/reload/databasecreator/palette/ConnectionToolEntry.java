/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
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
 * ���� �� 
 * ����ʱ�䣺2005-9-4
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
