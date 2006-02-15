/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
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
 * 描述 ： 
 * 创建时间：2005-9-3
 */
public class TableToolEntry extends CreationToolEntry {

    public TableToolEntry() {
        super("Table", "Create a table", new DbCreationFactory(Table.class), ImageProvider.TABLE_ICON, null);
    }
}
