/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.palette;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-9-3
 */
public class PaletteFactory {
    
    private PaletteRoot root;
    
    private PaletteDrawer defaultTools;
    
    private PaletteDrawer dbTools;
    
    private static PaletteFactory instance = null;
    private PaletteFactory(){}
    
    public static PaletteFactory INSTANCE(){
        if(instance == null) instance = new PaletteFactory();
        return instance;
    }
    
    public PaletteRoot createPaletteRoot(){
//        if(root != null) return root;
        
        root = new PaletteRoot();
        root.add(createDefaultToolBox());
        root.add(createDbToolBox());
        return root;
    }
    
    private PaletteDrawer createDefaultToolBox(){
        defaultTools = new PaletteDrawer("Default tools");
        
        defaultTools.add(new SelectionToolEntry());
        
        return defaultTools;
    }
    
    private PaletteDrawer createDbToolBox(){
        dbTools = new PaletteDrawer("DataBase tools");
        
        dbTools.add(new TableToolEntry());
        dbTools.add(new ColumnToolEntry());
        dbTools.add(new ConnectionToolEntry());
        
        return dbTools;
    }
}
