/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-12
 *
 */
package com.uxteam.reload.databasecreator.editpart;


import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.model.Connection;
import com.uxteam.reload.databasecreator.model.Schema;
import com.uxteam.reload.databasecreator.model.Table;

/**
 * @author <b>��ѩ</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-12
 */
public class DBEditPartFactory implements EditPartFactory {

    /* (non-Javadoc)
     * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
     */
    public EditPart createEditPart(EditPart context, Object model) {
        // TODO Auto-generated method stub
        EditPart part = null;
        if(model instanceof Schema){
            part = new SchemaEditPart();
        }
        if(model instanceof Table){
            part = new TableEditPart();
        }
        if(model instanceof Column){
            part = new ColumnEditPart();
        }
        if(model instanceof Connection)
            part = new ConnectionEditPart();
        if(part != null) part.setModel(model);
        return part;
    }

}
