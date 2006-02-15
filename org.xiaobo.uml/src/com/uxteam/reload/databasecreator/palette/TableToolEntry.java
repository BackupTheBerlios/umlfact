/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.palette;


import org.eclipse.gef.palette.CreationToolEntry;

import com.uxteam.reload.databasecreator.model.Table;
import com.uxteam.reload.databasecreator.resource.ImageProvider;

/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-9-3
 */
public class TableToolEntry extends CreationToolEntry {

    public TableToolEntry() {
        super("Table", "Create a table", new DbCreationFactory(Table.class), ImageProvider.TABLE_ICON, null);
    }
}
