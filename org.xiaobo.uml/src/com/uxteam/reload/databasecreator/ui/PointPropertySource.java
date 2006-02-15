/*
 * ������ֻ���ο�ѧϰ�������������������Խ��ô��������κ�Ӫ��Ŀ��
 * ���������� <email> black_frezee@163.com </email>��ϵ 
 * Created on 2005-8-5
 *
 */
package com.uxteam.reload.databasecreator.ui;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * @author ��ѩ
 *
 * ���� �� 
 * ����ʱ�䣺2005-8-5
 */
public class PointPropertySource implements IPropertySource {

	public static final String ID_X = "id x";

	public static final String ID_Y = "id y";

	public static IPropertyDescriptor[] descriptor;

	static {
		TextPropertyDescriptor t1 = new TextPropertyDescriptor(ID_X,
				"X");
		t1.setValidator(NumberCellEditorValidator.INSTANCE());
		TextPropertyDescriptor t2 = new TextPropertyDescriptor(ID_Y,
				"Y");
		t2.setValidator(NumberCellEditorValidator.INSTANCE());
		t2.setLabelProvider(TextPropertyLabelProvider.INSTANCE());
		t1.setLabelProvider(TextPropertyLabelProvider.INSTANCE());
		descriptor = new IPropertyDescriptor[] { t1, t2 };
	}

	private Point point = null;

	public PointPropertySource(Point point) {
		this.point = point.getCopy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {
	   return point;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return descriptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		System.out.println();
		if (id.equals(ID_X)) {
			return String.valueOf(point.x);
		}
		if (id.equals(ID_Y)) {
			return String.valueOf(point.y);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
	 */
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub
		System.out.println("Reset");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object,
	 *      java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		System.out.println();
		if (id.equals(ID_X)) {
			point.x = Integer.parseInt((String)value);
		}
		if (id.equals(ID_Y)) {
			point.y = Integer.parseInt((String)value);
		}
	}
	/**
	 * @return ���� point.
	 */
	public Point getPoint() {
		return point;
	}
	/**
	 * @param ��point����Ϊ point 
	 */
	public void setPoint(Point point) {
		this.point = point;
	}
}
