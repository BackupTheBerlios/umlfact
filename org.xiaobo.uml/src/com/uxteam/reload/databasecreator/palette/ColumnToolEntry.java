/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.palette;


import org.eclipse.gef.palette.CreationToolEntry;

import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.resource.ImageProvider;

/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-9-3
 */
public class ColumnToolEntry extends CreationToolEntry {

    public ColumnToolEntry(){
        super("Column", "Create a column", new DbCreationFactory(Column.class), ImageProvider.COLUMN_ICON, null);
    }

}
