/*
 * 本代码只供参考学习，不经本人允许不得擅自将该代码用于任何营利目的
 * 有疑问请与 <email> black_frezee@163.com </email>联系 
 * Created on 2005-8-2
 *
 */
package com.uxteam.reload.databasecreator.ui;

import org.eclipse.jface.viewers.ICellEditorValidator;

/**
 * @author 彭雪
 *
 * 描述 ： 
 * 创建时间：2005-8-5
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
