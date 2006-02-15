/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-2
 *
 */
package com.uxteam.reload.databasecreator.ui;

import org.eclipse.jface.viewers.ICellEditorValidator;

/**
 * @author ��ѩ
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-5
 */
public class NumberCellEditorValidator implements ICellEditorValidator {

	private static  NumberCellEditorValidator instance = new NumberCellEditorValidator();
	
	private NumberCellEditorValidator(){}
	
	public static NumberCellEditorValidator INSTANCE(){
		return instance;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellEditorValidator#isValid(java.lang.Object)
	 */
	public String isValid(Object value) {
		// TODO Auto-generated method stub
		try{
			new Integer((String)value);
			return null;
		}catch(Exception e){
			return "Must Be munber" ;
		}
	}

}
