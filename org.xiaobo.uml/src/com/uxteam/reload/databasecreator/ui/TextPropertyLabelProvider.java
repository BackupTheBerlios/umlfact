/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-30
 *
 */
package com.uxteam.reload.databasecreator.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-30
 */
public class TextPropertyLabelProvider extends LabelProvider {
    public static TextPropertyLabelProvider INSTANCE(){
        if(instance == null)
            instance = new TextPropertyLabelProvider();
        return instance;
    }
    private static TextPropertyLabelProvider instance = null;
    public Image getImage(Object element) {
        return null;
    }
}
