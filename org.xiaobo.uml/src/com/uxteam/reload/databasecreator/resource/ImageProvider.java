/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.resource;


import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.uxteam.reload.databasecreator.DatabaseCreatorPlugin;

/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-9-3
 */
public class ImageProvider {
    
    private ImageProvider(){}
    
    public static final ImageDescriptor TABLE_ICON = createImage("icons/full/table.gif");
    
    public static final ImageDescriptor COLUMN_ICON = createImage("icons/full/column.gif");
    
    public static ImageDescriptor createImage(String url){
       try{
           return AbstractUIPlugin.imageDescriptorFromPlugin(DatabaseCreatorPlugin.PLUGIN_ID,url);
       }catch(Exception e){
           return null;
       }
    }
}
