/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-9-3
 *
 */
package com.uxteam.reload.databasecreator.editpolicy;


import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

import com.uxteam.reload.databasecreator.editpart.ColumnEditPart;
import com.uxteam.reload.databasecreator.figure.ColumnFigure;

/**
 * @author <b>Dart</b>
 *
 * ���� �� 
 * ����ʱ�䣺2005-9-3
 */
public class ColumnSelectionEditPolicy extends NonResizableEditPolicy {
    
    private ColumnFigure getLabel() {
    	ColumnEditPart part = (ColumnEditPart)getHost();
    	return ((ColumnFigure)part.getFigure());
    }	
    protected void hideFocus() {
    	getLabel().setFocus(false);
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#hideSelection()
     */
    protected void hideSelection() {
    	getLabel().setSelected(false);
    	getLabel().setFocus(false);
    	
    }

    /**
     * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#showFocus()
     */
    protected void showFocus() {
    	getLabel().setFocus(true);
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#showSelection()
     */
    protected void showPrimarySelection() {
    	getLabel().setSelected(true);
    	getLabel().setFocus(true);
    }

    /**
     * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#showSelection()
     */
    protected void showSelection() {
    	getLabel().setSelected(true);
    	getLabel().setFocus(false);
    }
}
