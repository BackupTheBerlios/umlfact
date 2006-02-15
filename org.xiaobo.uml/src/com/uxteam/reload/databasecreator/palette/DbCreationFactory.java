/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.palette;


import org.eclipse.gef.requests.CreationFactory;

import com.uxteam.reload.databasecreator.model.Column;
import com.uxteam.reload.databasecreator.model.Table;

/**
 * @author <b>Dart</b>
 *
 * 描述 ： 
 * 创建时间：2005-9-3
 */
public class DbCreationFactory implements CreationFactory {

    private Class type;
    public DbCreationFactory(Class type){
        setType(type);
    }
    /* (non-Javadoc)
     * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
     */
    public Object getNewObject() {
        if(type == Table.class){
            return new Table();
        }
        if(type == Column.class) return new Column();
        return null;
    }

    /* (non-Javadoc)
     * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
     */
    public Object getObjectType() {
        // TODO Auto-generated method stub
        return getType();
    }

    /**
     * @return 返回 type.
     */
    public Class getType() {
        return type;
    }
    /**
     * @param type 设置 type 
     */
    public void setType(Class type) {
        this.type = type;
    }
}
